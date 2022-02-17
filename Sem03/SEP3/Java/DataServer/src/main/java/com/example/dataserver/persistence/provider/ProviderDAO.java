package com.example.dataserver.persistence.provider;

import com.example.dataserver.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.concurrent.Future;

/**
 * Interface for CRUD operations of Provider object
 */
public interface ProviderDAO {
    /**
     * Method for creating provider
     * @param provider provider to be created
     * @return future asynchronous result containing user with provider
     */
    Future<User> createProvider(User provider);

    /**
     * Method for getting all providers
     * @param pageable settings for page request
     * @return future asynchronous result containing page with provider users
     */
    Future<Page<User>> getAllProviders(Pageable pageable);

    /**
     * Method for getting provider by id
     * @param id id of provider
     * @return future asynchronous result containing user with provider
     */
    Future<User> getProviderById(int id);

    /**
     * Method for editing provider
     * @param provider provider that is edited
     * @return future asynchronous result containing user with provider
     */
    Future<User> editProvider(User provider);

    /**
     * Method for removing provider
     * @param id id of provider to be removed
     */
    void removeProvider(int id);

    /**
     * Method for getting all not approved providers
     * @param pageable settings for page request
     * @return future asynchronous result containing page with provider users
     */
    Future<Page<User>> getAllNotApprovedProviders(Pageable pageable);

    /**
     * Method for getting all providers by name
     * @param name name of providers
     * @param pageable settings for page request
     * @return future asynchronous result containing page with provider users
     */
    Future<Page<User>> getAllByName(String name, Pageable pageable);
}
