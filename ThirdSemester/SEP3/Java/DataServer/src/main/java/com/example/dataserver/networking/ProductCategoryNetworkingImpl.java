package com.example.dataserver.networking;

import com.example.dataserver.models.Category;
import com.example.dataserver.persistence.category.CategoryDAO;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import networking.category.CategoriesMessage;
import networking.category.CategoryMessage;
import networking.category.CategoryServiceGrpc;
import networking.page.PageMessage;
import networking.request.PageRequestMessage;
import networking.request.RequestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@GrpcService
@EnableAsync
public class ProductCategoryNetworkingImpl extends CategoryServiceGrpc.CategoryServiceImplBase
{
    private CategoryDAO categoryDAO;

    @Autowired
    public ProductCategoryNetworkingImpl(CategoryDAO categoryDAO)
    {
        this.categoryDAO = categoryDAO;
    }

    @Async
    @Override
    public void getAllProductCategories(PageRequestMessage request, StreamObserver<CategoriesMessage> responseObserver)
    {
        PageRequest pageRequest = PageRequest.of(request.getPageNumber(), request.getPageSize());
        var allCategoriesFuture = categoryDAO.getAllCategories(pageRequest);
        categories(responseObserver, allCategoriesFuture);
    }

    @Async
    @Override
    public void addProductCategory(CategoryMessage request, StreamObserver<CategoryMessage> responseObserver)
    {
        var category = new Category(request);
        try
        {
            var createdCategoryFuture = categoryDAO.addProductCategory(category);
            var createdCategory = getObjectAfterDone(createdCategoryFuture);
            CategoryMessage categoryMessage = createdCategory.toMessage();
            responseObserver.onNext(categoryMessage);
            responseObserver.onCompleted();
        }
        catch (Exception e)
        {
            responseObserver.onError(Status.INTERNAL.withDescription("Could not create the category in the database.").asException());
        }
    }

    @Async
    @Override
    public void editProductCategory(CategoryMessage request, StreamObserver<CategoryMessage> responseObserver)
    {
        var category = new Category(request);
        try
        {
            var editedCategoryFuture = categoryDAO.editProductCategory(category);
            var editedCategory = getObjectAfterDone(editedCategoryFuture);
            CategoryMessage categoryMessage = editedCategory.toMessage();
            responseObserver.onNext(categoryMessage);
            responseObserver.onCompleted();
        }
        catch (Exception e)
        {
            responseObserver.onError(Status.INTERNAL.withDescription("Could not save the edited category to the database.").asException());
        }
    }

    private synchronized void categories(StreamObserver<CategoriesMessage> responseObserver, Future<Page<Category>> pageFuture)
    {
        try
        {
            var page = getObjectAfterDone(pageFuture);
            var collect = page.getContent().stream().map(Category::toMessage)
                              .collect(Collectors.toList());
            PageMessage pageInfo = PageMessage.newBuilder().setPageNumber(page.getNumber()).setTotalPages(page.getTotalPages())
                                              .setTotalElements(page.getTotalPages()).build();
            var categoriesMessage = CategoriesMessage.newBuilder().addAllCategories(collect).setPageInfo(pageInfo).build();
            responseObserver.onNext(categoriesMessage);
            responseObserver.onCompleted();
        }
        catch (Exception e)
        {
            responseObserver.onError(Status.INTERNAL.withDescription("Could not fetch the categories from the database.").asException());
        }
    }

    private synchronized <T> T getObjectAfterDone(Future<T> future) throws Exception
    {
        T object;
        while (true)
        {
            if (future.isDone())
            {
                try
                {
                    object = future.get();
                    break;
                }
                catch (ExecutionException | InterruptedException e)
                {
                    throw new Exception(e);
                }
            }
        }
        return object;
    }
}
