package com.example.dataserver.persistence.experience;

import com.example.dataserver.models.Experience;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.concurrent.Future;

/**
 * Interface for CRUD operations of Experience object
 */
public interface ExperienceDAO {
    /**
     * Method for creating experience
     * @param experience experience to be added
     * @return future asynchronous result containing added experience
     */
    Future<Experience> addExperience(Experience experience);

    /**
     * Method for getting all experiences of provider
     * @param provider id of provider to fetch his experiences
     * @param pageable setting for page request
     * @return future asynchronous result containing provider experiences
     */
    Future<Page<Experience>> getAllProviderExperiences(int provider, Pageable pageable);

    /**
     * Method for getting all experiences
     * @param pageable setting for page request
     * @return future asynchronous result containing experiences
     */
    Future<Page<Experience>> getAllWebShopExperiences(Pageable pageable);

    /**
     * Method for getting experience by id
     * @param id id of experience to be returned
     * @return future asynchronous result containing experience
     */
    Future<Experience> getExperienceById(int id);

    /**
     * Method for checking if experience is in stock
     * @param id id of experience
     * @param quantity quantity of experience to be checked
     * @return future asynchronous result containing boolean representation of experience being in stock
     */
    Future<Boolean> isInStock(int id, int quantity);

    /**
     * Method for deleting experience
     * @param experienceId id of experience to be deleted
     */
    void deleteExperience(int experienceId);

    /**
     * Method for removing stock of an experience
     * @param id id of experience which stock is to delete
     * @param quantity quantity to delete
     */
    void removeStock(int id, int quantity);

    /**
     * Method for getting all providers experiences that contains name
     * @param id id of provider
     * @param name name that experiences needs to contain
     * @param pageable settings for page request
     * @return future asynchronous result containing page of experiences
     */
    Future<Page<Experience>> getAllProviderExperiencesByName(int id, String name, Pageable pageable);

    /**
     * Method for getting experiences by category
     * @param id id of category
     * @param pageable settings for page request
     * @return future asynchronous result containing page of experiences
     */
    Future<Page<Experience>> getExperienceByCategory(int id, Pageable pageable);

    /**
     * Method for getting top three experiences
     * @return future asynchronous result containing list of experiences
     */
    Future<ArrayList<Experience>> getTopExperiences();

    /**
     * Method for getting sorted experiences
     * @param name name query of experiences
     * @param price price query of experiences
     * @param pageable settings for page request
     * @return future asynchronous result containing sorted experiences
     */
    Future<Page<Experience>> getSortedExperiences(String name, double price, Pageable pageable);

    /**
     * Method for editing experience
     * @param experience experience to be edited
     * @return future asynchronous result containing edited experience
     */
    Future<Experience> editExperience(Experience experience);
}
