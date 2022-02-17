package com.example.dataserver.persistence.order;


import com.example.dataserver.models.Order;
import com.example.dataserver.models.ProviderVouchers;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.concurrent.Future;

/**
 * Interface for CRUD operations of Order object
 */
public interface OrderDAO {
    /**
     * Method for creating order
     * @param order order to be created
     * @return future asynchronous result containing craeted order
     */
    Future<Order> createOrder(Order order);

    /**
     * Method for getting all customer orders
     * @param id id of customer
     * @param pageable settings for page request
     * @return future asynchronous result containing page with customer orders
     */
    Future<Page<Order>> getAllCustomerOrders(int id, Pageable pageable);

    /**
     * Method for getting order by id
     * @param id id of order to be returned
     * @return future asynchronous result containing order
     */
    Future<Order> getOrderById(int id);

    /**
     * Method for getting provider vouchers
     * @param providerId id of provider
     * @param pageable settings for page request
     * @return future asynchronous result containing page with provider vouchers
     */
    Future<PagedListHolder<ProviderVouchers>> getProviderVouchers(int providerId, Pageable pageable);
}
