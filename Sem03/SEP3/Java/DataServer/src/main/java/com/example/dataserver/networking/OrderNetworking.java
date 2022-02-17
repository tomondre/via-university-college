package com.example.dataserver.networking;

import com.example.dataserver.models.Order;
import com.example.dataserver.models.ProviderVouchers;
import com.example.dataserver.persistence.order.OrderDAO;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import networking.order.OrderListMessage;
import networking.order.OrderMessage;
import networking.order.OrderServiceGrpc;
import networking.order.VoucherListMessages;
import networking.page.PageMessage;
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
public class OrderNetworking extends OrderServiceGrpc.OrderServiceImplBase {

    private OrderDAO orderDAO;

    @Autowired
    public OrderNetworking(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void createOrder(OrderMessage request, StreamObserver<OrderMessage> responseObserver) {
        var orderFuture = orderDAO.createOrder(new Order(request));
        var order = getObjectAfterDone(orderFuture);
        responseObserver.onNext(order.toMessage());
        responseObserver.onCompleted();
    }

    @Async
    @Override
    public void getAllCustomerOrders(RequestMessage request, StreamObserver<OrderListMessage> responseObserver) {
        PageRequest pageRequest = PageRequest.of(request.getPageInfo().getPageNumber(), request.getPageInfo().getPageSize());
        var ordersFuture = orderDAO.getAllCustomerOrders(request.getId(), pageRequest);
        orders(responseObserver, ordersFuture);
    }

    @Async
    @Override
    public void getOrderById(RequestMessage request, StreamObserver<OrderMessage> responseObserver) {
        var orderByIdFuture = orderDAO.getOrderById(request.getId());
        var orderById = getObjectAfterDone(orderByIdFuture);
        responseObserver.onNext(orderById.toMessage());
        responseObserver.onCompleted();
    }
    @Async
    @Override
    public void getAllProviderVouchers(RequestMessage request, StreamObserver<VoucherListMessages> responseObserver) {
        PageRequest pageRequest = PageRequest.of(request.getPageInfo().getPageNumber(), request.getPageInfo().getPageSize());
        var vouchersFuture = orderDAO.getProviderVouchers(request.getId(), pageRequest);
        var page = getObjectAfterDone(vouchersFuture);
        var collect = page.getPageList().stream().map(ProviderVouchers::toMessage).collect(Collectors.toList());
        PageMessage pageInfo =
                PageMessage.newBuilder().setPageNumber(page.getPage()).setTotalPages(page.getPageCount())
                           .setTotalElements(page.getNrOfElements()).build();
        var voucherMessage = VoucherListMessages.newBuilder().addAllVouchers(collect).setPageInfo(pageInfo).build();
        responseObserver.onNext(voucherMessage);
        responseObserver.onCompleted();
    }

    private void orders(StreamObserver<OrderListMessage> responseObserver, Future<Page<Order>> pageFuture)
    {
        var page = getObjectAfterDone(pageFuture);
        var collect = page.getContent().stream().map(Order::toMessage)
                          .collect(Collectors.toList());
        PageMessage pageInfo = PageMessage.newBuilder().setPageNumber(page.getNumber()).setTotalPages(page.getTotalPages())
                                          .setTotalElements(page.getTotalPages()).build();
        var providersMessage = OrderListMessage.newBuilder().addAllOrders(collect).setPageInfo(pageInfo).build();
        responseObserver.onNext(providersMessage);
        responseObserver.onCompleted();
    }

    private <T> T getObjectAfterDone(Future<T> future)
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
                    e.printStackTrace();
                }
            }
        }
        return object;
    }
}
