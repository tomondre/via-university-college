package com.example.dataserver.persistence.customer;

import com.example.dataserver.models.Customer;
import com.example.dataserver.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.concurrent.Future;

/**
 * Interface for CRUD operations of Customer object
 */
public interface CustomerDAO
{
  /**
   * Method for creating customer
   * @param customer user object containing customer to create
   * @return future asynchronous result with created customer
   */
  Future<User> createCustomer(User customer);

  /**
   * Method for getting all customers
   * @param pageable settings for page request
   * @return future asynchronous result with page of Users containing customers
   */
  Future<Page<User>> getAllCustomers(Pageable pageable);

  /**
   * Method for deleting customer
   * @param customerId id of customer to be deleted
   */
  void deleteCustomer(int customerId);

  /**
   * Method for getting customer by id
   * @param id id of customer to be returned
   * @return future asynchronous result of User containing Customer
   */
  Future<User> getCustomerById(int id);

  /**
   * Method for editing customer
   * @param customer user object containing customer to edit
   * @return future asynchronous result of user containing edited customer
   */
  Future<User> editCustomer(User customer);

  /**
   * Method for getting customers that contains input in name
   * @param name name of customers to return
   * @param pageable settings for page request
   * @return future asynchronous result with page of Users containing customers
   */
  Future<Page<User>> findCustomerByName(String name, Pageable pageable);
}
