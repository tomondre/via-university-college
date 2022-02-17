package com.example.dataserver.networking;

import com.example.dataserver.models.Await;
import com.example.dataserver.models.Experience;
import com.example.dataserver.persistence.experience.ExperienceDAO;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import networking.experience.ExperienceListMessage;
import networking.experience.ExperienceMessage;
import networking.experience.ExperienceServiceGrpc;
import networking.page.PageMessage;
import networking.request.PageRequestMessage;
import networking.request.RequestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Future;
import java.util.stream.Collectors;

@GrpcService
@EnableAsync
public class ExperienceNetworking extends ExperienceServiceGrpc.ExperienceServiceImplBase
{
    private ExperienceDAO experienceDAO;

    @Autowired
    public ExperienceNetworking(ExperienceDAO experienceDAO)
    {
        this.experienceDAO = experienceDAO;
    }

    @Async
    @Override
    public void getAllProviderExperiences(RequestMessage request,
                                          StreamObserver<ExperienceListMessage> responseObserver)
    {
        var pageRequest = PageRequest.of(request.getPageInfo().getPageNumber(), request.getPageInfo().getPageSize());
        var pageFuture = experienceDAO.getAllProviderExperiences(request.getId(), pageRequest);
        experiences(responseObserver, pageFuture);
    }

    @Async
    @Override
    public void getAllWebShopExperiences(PageRequestMessage request,
                                         StreamObserver<ExperienceListMessage> responseObserver)
    {
        PageRequest pageRequest = PageRequest.of(request.getPageNumber(), request.getPageSize());
        var pageFuture = experienceDAO.getAllWebShopExperiences(pageRequest);
        experiences(responseObserver, pageFuture);
    }

    @Async
    @Override
    public void addExperience(ExperienceMessage request, StreamObserver<ExperienceMessage> responseObserver)
    {
        try
        {
            var experience = Await.await(experienceDAO.addExperience(new Experience(request)));
            responseObserver.onNext(experience.toMessage());
            responseObserver.onCompleted();
        }
        catch (Exception e)
        {
            responseObserver.onError(
                    Status.INTERNAL.withDescription("Could not save the experience to the database.").asException());
        }
    }

    @Async
    @Override
    public void getExperienceById(RequestMessage request, StreamObserver<ExperienceMessage> responseObserver)
    {
        try
        {
            Experience experienceById = Await.await(experienceDAO.getExperienceById(request.getId()));
            responseObserver.onNext(experienceById.toMessage());
            responseObserver.onCompleted();
        }
        catch (Exception e)
        {
            responseObserver.onError(
                    Status.INTERNAL.withDescription("Could not fetch the experience from the database.").asException());
        }
    }

    @Async
    @Override
    public void isInStock(RequestMessage request, StreamObserver<RequestMessage> responseObserver)
    {
        try
        {
            boolean inStock = Await.await(experienceDAO.isInStock(request.getId(), request.getQuantity()));
            responseObserver.onNext(RequestMessage.newBuilder().setResponse(inStock).build());
            responseObserver.onCompleted();
        }
        catch (Exception e)
        {
            responseObserver.onError(
                    Status.INTERNAL.withDescription("Could not fetch the experience stock from the database.")
                                   .asException());
        }
    }

    @Async
    @Override
    public void deleteExperience(RequestMessage request, StreamObserver<RequestMessage> responseObserver)
    {
        experienceDAO.deleteExperience(request.getId());
        responseObserver.onNext(RequestMessage.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Async
    @Override
    public void removeStock(RequestMessage request, StreamObserver<RequestMessage> responseObserver)
    {
        experienceDAO.removeStock(request.getId(), request.getQuantity());
        responseObserver.onNext(RequestMessage.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Async
    @Override
    public void getExperienceByCategory(RequestMessage request, StreamObserver<ExperienceListMessage> responseObserver)
    {
        var pageRequest = PageRequest.of(request.getPageInfo().getPageNumber(), request.getPageInfo().getPageSize());
        var pageFuture = experienceDAO.getExperienceByCategory(request.getId(), pageRequest);
        experiences(responseObserver, pageFuture);
    }

    @Async
    @Override
    public void getTopExperiences(RequestMessage request, StreamObserver<ExperienceListMessage> responseObserver)
    {
        try
        {
            var topExperiences = Await.await(experienceDAO.getTopExperiences());
            var collect = topExperiences.stream().map(Experience::toMessage).collect(Collectors.toList());
            var experienceListMessage = ExperienceListMessage.newBuilder().addAllExperiences(collect).build();
            responseObserver.onNext(experienceListMessage);
            responseObserver.onCompleted();
        }
        catch (Exception e)
        {
            responseObserver.onError(Status.INTERNAL.withDescription("Could not fetch the top 3 experiences from the database").asException());
        }
    }

    @Async
    @Override
    public void getAllProviderExperiencesByName(RequestMessage request,
                                                StreamObserver<ExperienceListMessage> responseObserver)
    {
        var pageRequest = PageRequest.of(request.getPageInfo().getPageNumber(), request.getPageInfo().getPageSize());
        var pageFuture =
                experienceDAO.getAllProviderExperiencesByName(request.getId(), request.getName(), pageRequest);
        experiences(responseObserver, pageFuture);
    }

    @Async
    @Override
    public void getSortedExperiences(RequestMessage request, StreamObserver<ExperienceListMessage> responseObserver)
    {
        PageRequest pageRequest = PageRequest.of(request.getPageInfo().getPageNumber(), request.getPageInfo().getPageSize());
        var pageFuture =
                experienceDAO.getSortedExperiences(request.getName(), request.getPrice(), pageRequest);
        experiences(responseObserver, pageFuture);
    }

    private synchronized void experiences(StreamObserver<ExperienceListMessage> responseObserver,
                                          Future<Page<Experience>> pageFuture)
    {
        try
        {
            var page = Await.await(pageFuture);
            var collect = page.getContent().stream().map(Experience::toMessage).collect(Collectors.toList());
            PageMessage pageInfo =
                    PageMessage.newBuilder().setPageNumber(page.getNumber()).setTotalPages(page.getTotalPages())
                               .setTotalElements(page.getTotalPages()).build();
            var experienceMessage =
                    ExperienceListMessage.newBuilder().addAllExperiences(collect).setPageInfo(pageInfo).build();
            responseObserver.onNext(experienceMessage);
            responseObserver.onCompleted();
        }
        catch (Exception e)
        {
            responseObserver.onError(
                    Status.INTERNAL.withDescription("Could not fetch the experiences from the database.")
                                   .asException());
        }
    }
}