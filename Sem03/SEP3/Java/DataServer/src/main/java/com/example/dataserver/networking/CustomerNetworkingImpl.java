package com.example.dataserver.networking;

import com.example.dataserver.models.Customer;
import com.example.dataserver.models.User;
import com.example.dataserver.persistence.customer.CustomerDAO;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import networking.customer.CustomerMessage;
import networking.customer.CustomerServiceGrpc;
import networking.customer.CustomersMessage;
import networking.page.PageMessage;
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
public class CustomerNetworkingImpl extends CustomerServiceGrpc.CustomerServiceImplBase {

    private CustomerDAO dao;

    @Autowired
    public CustomerNetworkingImpl(CustomerDAO dao) {
        this.dao = dao;
    }

    @Async
    @Override
    public void createCustomer(CustomerMessage request, StreamObserver<UserMessage> responseObserver) {

        var customer = new Customer(request);
        var user = customer.getUser();
        user.setCustomer(customer);

        try {
            var createdCustomerFuture = dao.createCustomer(user);
            var createdCustomer = getObjectAfterDone(createdCustomerFuture);
            UserMessage userMessage = createdCustomer.toMessage();
            responseObserver.onNext(userMessage);
            responseObserver.onCompleted();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription("Could not save the customer to the database.").asException());
            System.out.println(e.getMessage());
        }
    }

    @Async
    @Override
    public void getAllCustomers(PageRequestMessage request,
                                StreamObserver<CustomersMessage> responseObserver) {
        var pageRequest = PageRequest.of(request.getPageNumber(), request.getPageSize());
        var page = dao.getAllCustomers(pageRequest);
        customers(responseObserver, page);
    }

    @Async
    @Override
    public void deleteCustomer(UserMessage request,
                               StreamObserver<CustomerMessage> responseObserver) {
        dao.deleteCustomer(request.getId());
        responseObserver.onNext(CustomerMessage.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Async
    @Override
    public void getCustomerById(UserMessage request, StreamObserver<CustomerMessage> responseObserver) {
        System.out.println("Customer> GetById request received.");
        try {
            var customerByIdFuture = dao.getCustomerById(request.getId());
            var customerById = getObjectAfterDone(customerByIdFuture);
            var customerMessage = customerById.toCustomerMessage();
            responseObserver.onNext(customerMessage);
            responseObserver.onCompleted();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription("Could not fetch the customer from the database.").asException());
        }
    }

    @Async
    @Override
    public void editCustomer(CustomerMessage request, StreamObserver<CustomerMessage> responseObserver) {
        var customer = new Customer(request);
        var user = customer.getUser();
        user.setCustomer(customer);
        try {
            var editedFuture = dao.editCustomer(user);
            var edited = getObjectAfterDone(editedFuture);
            CustomerMessage customerMessage = edited.toCustomerMessage();
            responseObserver.onNext(customerMessage);
            responseObserver.onCompleted();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription("Could not save the edited provider to the database.").asException());
        }

    }

    @Async
    @Override
    public void findCustomerByName(RequestMessage request, StreamObserver<CustomersMessage> responseObserver) {
        var name = request.getName();
        var pageRequest = PageRequest.of(request.getPageInfo().getPageNumber(), request.getPageInfo().getPageSize());
        var page = dao.findCustomerByName(name, pageRequest);
        customers(responseObserver, page);
    }

    private synchronized void customers(StreamObserver<CustomersMessage> responseObserver, Future<Page<User>> pageFuture) {
        try {
            Page<User> page = getObjectAfterDone(pageFuture);
            var collect = page.getContent().stream().map(User::toCustomerMessage)
                    .collect(Collectors.toList());
            PageMessage pageInfo = PageMessage.newBuilder().setPageNumber(page.getNumber()).setTotalPages(page.getTotalPages())
                    .setTotalElements(page.getTotalPages()).build();
            var customersMessage = CustomersMessage.newBuilder().addAllCustomers(collect).setPage(pageInfo).build();
            responseObserver.onNext(customersMessage);
            responseObserver.onCompleted();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            responseObserver.onError(
                    Status.INTERNAL.withDescription("Could not fetch the customers from the database.").asException());

        }
    }

    private synchronized <T> T getObjectAfterDone(Future<T> future) throws Exception {
        T object;
        while (true) {
            if (future.isDone()) {
                try {
                    object = future.get();
                    break;
                } catch (ExecutionException | InterruptedException e) {
                    throw new Exception(e);
                }
            }
        }
        return object;
    }
}
