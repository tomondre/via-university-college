package com.example.dataserver.persistence.experience;

import com.example.dataserver.models.Category;
import com.example.dataserver.models.Experience;
import com.example.dataserver.models.User;
import com.example.dataserver.persistence.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.concurrent.Future;

@Repository
@EnableAsync
public class ExperienceDAOImpl implements ExperienceDAO
{
    @PersistenceContext
    private EntityManager em;
    private final ExperienceRepository repository;

    @Autowired
    public ExperienceDAOImpl(ExperienceRepository repository)
    {
        this.repository = repository;
    }

    @Async
    @Override
    public Future<Experience> addExperience(Experience experience)
    {
        User user = em.getReference(User.class, experience.getExperienceProvider().getId());
        Category category = em.getReference(Category.class, experience.getExperienceCategory().getId());
        experience.setExperienceCategory(category);
        experience.setExperienceProvider(user);
        return new AsyncResult<>(repository.save(experience));
    }

    @Async
    @Override
    public Future<Page<Experience>> getAllProviderExperiences(int provider, Pageable pageable)
    {
        return new AsyncResult<>(repository.getAllByExperienceProviderId(provider, pageable));
    }

    @Async
    @Override
    public Future<Page<Experience>> getAllWebShopExperiences(Pageable pageable)
    {
        return new AsyncResult<>(repository.getAllByStockGreaterThan(0, pageable));
    }

    @Async
    @Override
    public Future<Experience> getExperienceById(int id)
    {
        return new AsyncResult<>(repository.findById(id));
    }

    @Async
    @Override
    public Future<Boolean> isInStock(int id, int quantity)
    {
        return new AsyncResult<>(repository.existsByIdAndStockIsGreaterThanEqual(id, quantity));
    }

    @Async
    @Override
    public void deleteExperience(int experienceId)
    {
        repository.deleteById(experienceId);
    }

    @Async
    @Override
    public void removeStock(int id, int quantity)
    {
        Experience byId = repository.findById(id);
        byId.setStock(byId.getStock() - quantity);
        repository.save(byId);
    }

    @Async
    @Override
    public Future<Page<Experience>> getExperienceByCategory(int id, Pageable pageable)
    {
        return new AsyncResult<>(repository.getAllByExperienceCategoryIdAndStockGreaterThan(id, 0, pageable));
    }

    @Async
    @Override
    public Future<Page<Experience>> getAllProviderExperiencesByName(int id, String name, Pageable pageable)
    {
        return new AsyncResult<>(repository.findAllByExperienceProviderIdAndNameContainsIgnoreCase(id, name, pageable));
    }

    @Async
    @Override
    public Future<ArrayList<Experience>> getTopExperiences()
    {
        return new AsyncResult<>(repository.findTop3ByStockAfter(0));
    }

    @Async
    @Override
    public Future<Page<Experience>> getSortedExperiences(String name, double price, Pageable pageable)
    {

        return new AsyncResult<>(
                repository.findAllByNameContainingIgnoreCaseAndPriceIsLessThanEqual(name, price, pageable));
    }
    @Async
    @Override
    public Future<Experience> editExperience(Experience experience) {
        Experience toEdit = repository.findById(experience.getId());

        toEdit.setName(experience.getName());
        toEdit.setPrice(experience.getPrice());
        toEdit.setStock(experience.getStock());
        toEdit.setDescription(experience.getDescription());
        toEdit.setExperienceValidity(experience.getExperienceValidity());
        Category reference = em.getReference(Category.class, experience.getExperienceCategory().getId());
        toEdit.setExperienceCategory(reference);
        toEdit.getAddress().setCity(experience.getAddress().getCity());
        toEdit.getAddress().setPostCode(experience.getAddress().getPostCode());
        toEdit.getAddress().setStreet(experience.getAddress().getStreet());
        toEdit.getAddress().setStreetNumber(experience.getAddress().getStreetNumber());
        repository.save(toEdit);
        return new AsyncResult<>(toEdit);
    }
}
