package com.example.dataserver.persistence.customer;

import com.example.dataserver.models.User;
import com.example.dataserver.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;

import java.util.concurrent.Future;

@Repository
@EnableAsync
public class CustomerDAOImpl implements CustomerDAO {

    private UserRepository repository;

    @Autowired
    public CustomerDAOImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Async
    @Override
    public Future<User> createCustomer(User customer) {
        return new AsyncResult<>(repository.save(customer));
    }

    @Async
    @Override
    public Future<Page<User>> getAllCustomers(Pageable pageable) {
        return new AsyncResult<>(repository.getAllByCustomer_FirstNameIsNotNull(pageable));
    }

    @Async
    @Override
    public void deleteCustomer(int customerId) {
        repository.deleteById(customerId);
    }

    @Async
    @Override
    public Future<Page<User>> findCustomerByName(String name, Pageable pageable) {
        return new AsyncResult<>(repository.findAllByCustomer_FirstNameContainingIgnoreCase(name, pageable));
    }

    @Async
    @Override
    public Future<User> getCustomerById(int id) {
        return new AsyncResult<>(repository.getUserById(id));
    }

    @Async
    @Override
    public Future<User> editCustomer(User customer) {
        User toEdit = repository.getUserById(customer.getId());
        toEdit.getCustomer().setFirstName(customer.getCustomer().getFirstName());
        toEdit.getCustomer().setLastName(customer.getCustomer().getLastName());
        toEdit.getCustomer().setPhoneNumber(customer.getCustomer().getPhoneNumber());
        toEdit.setEmail(customer.getEmail());
        toEdit.getCustomer().getAddress().setStreet(customer.getCustomer().getAddress().getStreet());
        toEdit.getCustomer().getAddress().setStreetNumber(customer.getCustomer().getAddress().getStreetNumber());
        toEdit.getCustomer().getAddress().setCity(customer.getCustomer().getAddress().getCity());
        toEdit.getCustomer().getAddress().setPostCode(customer.getCustomer().getAddress().getPostCode());
        toEdit.setPassword(customer.getPassword());

        repository.save(toEdit);
        return new AsyncResult<>(toEdit);
    }
}
