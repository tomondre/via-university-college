package com.example.dataserver.networking;

import com.example.dataserver.models.Provider;
import com.example.dataserver.models.User;
import com.example.dataserver.persistence.provider.ProviderDAO;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import networking.page.PageMessage;
import networking.provider.ProviderMessage;
import networking.provider.ProviderServiceGrpc;
import networking.provider.ProvidersMessage;
import networking.request.PageRequestMessage;
import networking.request.RequestMessage;
import networking.user.UserMessage;
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
public class ProviderNetworkingImpl extends ProviderServiceGrpc.ProviderServiceImplBase
{

    private ProviderDAO model;

    @Autowired
    public ProviderNetworkingImpl(ProviderDAO model)
    {
        this.model = model;
    }

    @Async
    @Override
    public void createProvider(ProviderMessage request, StreamObserver<UserMessage> responseObserver)
    {
        var provider = new Provider(request);
        var user = provider.getUser();
        user.setProvider(provider);
        var providerFuture = model.createProvider(user);
        var providerCreated = new User();
        try
        {
            providerCreated = getObjectAfterDone(providerFuture);

            UserMessage userMessage = providerCreated.toMessage();
            responseObserver.onNext(userMessage);
            responseObserver.onCompleted();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription("Could not save the provider to the database.").asException());
        }
    }

    @Async
    @Override
    public void getAllProviders(PageRequestMessage request, StreamObserver<ProvidersMessage> responseObserver)
    {
        var pageable = PageRequest.of(request.getPageNumber(), request.getPageSize());
        var allProviders = model.getAllProviders(pageable);
        providers(responseObserver, allProviders);
    }

    @Async
    @Override
    public void getProviderById(RequestMessage request, StreamObserver<ProviderMessage> responseObserver)
    {
        var providerByIdFuture = model.getProviderById(request.getId());
        try
        {
            var providerById = getObjectAfterDone(providerByIdFuture);
            var provider = providerById.toProviderMessage();
            responseObserver.onNext(provider);
            responseObserver.onCompleted();
        }
        catch (Exception e)
        {
System.out.println(e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription("Could not fetch the data from the database.").asException());
        }
    }

    @Async
    @Override
    public void editProvider(ProviderMessage request, StreamObserver<ProviderMessage> responseObserver)
    {
        var provider = new Provider(request);
        var user = provider.getUser();
        user.setProvider(provider);
        var editedFuture = model.editProvider(user);
        try
        {
            User edited = getObjectAfterDone(editedFuture);
            ProviderMessage providerMessage = edited.toProviderMessage();
            responseObserver.onNext(providerMessage);
            responseObserver.onCompleted();
        }
        catch (Exception e)
        {
System.out.println(e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription("Could not perform the edit in the database").asException());
        }
    }

    @Async
    @Override
    public void removeProvider(RequestMessage request, StreamObserver<ProviderMessage> responseObserver)
    {
        model.removeProvider(request.getId());
        responseObserver.onNext(ProviderMessage.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Async
    @Override
    public void getAllNotApprovedProviders(PageRequestMessage request, StreamObserver<ProvidersMessage> responseObserver)
    {
            PageRequest pageRequest = PageRequest.of(request.getPageNumber(), request.getPageSize());
            var allNotApprovedProviders = model.getAllNotApprovedProviders(pageRequest);
            providers(responseObserver, allNotApprovedProviders);
    }

    @Async
    @Override
    public void getAllByName(RequestMessage request, StreamObserver<ProvidersMessage> responseObserver)
    {
        PageRequest pageRequest = PageRequest.of(request.getPageInfo().getPageNumber(), request.getPageInfo().getPageSize());
        var allByName = model.getAllByName(request.getName(), pageRequest);
        providers(responseObserver, allByName);
    }

    private synchronized void providers(StreamObserver<ProvidersMessage> responseObserver, Future<Page<User>> pageFuture)
    {
        try
        {
            Page<User> page = getObjectAfterDone(pageFuture);
            var collect = page.getContent().stream().map(User::toProviderMessage)
                              .collect(Collectors.toList());
            PageMessage pageInfo = PageMessage.newBuilder().setPageNumber(page.getNumber()).setTotalPages(page.getTotalPages())
                                              .setTotalElements(page.getTotalPages()).build();
            var providersMessage = ProvidersMessage.newBuilder().addAllProviders(collect).setPageInfo(pageInfo).build();
            responseObserver.onNext(providersMessage);
            responseObserver.onCompleted();
        }
        catch (Exception e)
        {
System.out.println(e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription("Could not fetch the data from the database").asException());
        }
    }

    private synchronized  <T> T getObjectAfterDone(Future<T> future) throws Exception
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
                catch (Exception e)
                {
                    throw new Exception();
                }
            }
        }
        return object;
    }
}