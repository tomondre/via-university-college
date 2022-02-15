package com.example.dataserver.persistence.provider;

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
public class ProviderDAOImpl implements ProviderDAO
{

    private final UserRepository repo;

    @Autowired
    public ProviderDAOImpl(UserRepository repo)
    {
        this.repo = repo;
    }

    @Async
    @Override
    public Future<User> createProvider(User provider)
    {
        return new AsyncResult<>(repo.save(provider));
    }

    @Async
    @Override
    public Future<Page<User>> getAllProviders(Pageable pageable)
    {
        return new AsyncResult<>(repo.getAllByProvider_isApproved(true, pageable));
    }

    @Async
    @Override
    public Future<User> getProviderById(int id)
    {
        return new AsyncResult<>(repo.findById(id).orElseThrow());
    }

    @Async
    @Override
    public Future<User> editProvider(User provider)
    {

        User toEdit = repo.getUserById(provider.getId());
        toEdit.getProvider().setCompanyName(provider.getProvider().getCompanyName());
        toEdit.getProvider().setCvr(provider.getProvider().getCvr());
        toEdit.getProvider().setDescription(provider.getProvider().getDescription());
        toEdit.getProvider().setPhoneNumber(provider.getProvider().getPhoneNumber());
        toEdit.getProvider().setApproved(provider.getProvider().isApproved());
        toEdit.setEmail(provider.getEmail());
        toEdit.setPassword(provider.getPassword());
        toEdit.getProvider().getAddress().setStreet(provider.getProvider().getAddress().getStreet());
        toEdit.getProvider().getAddress().setStreetNumber(provider.getProvider().getAddress().getStreetNumber());
        toEdit.getProvider().getAddress().setCity(provider.getProvider().getAddress().getCity());
        toEdit.getProvider().getAddress().setPostCode(provider.getProvider().getAddress().getPostCode());

        repo.save(toEdit);
        return new AsyncResult<>(toEdit);
    }

    @Async
    @Override
    public void removeProvider(int id)
    {
        repo.deleteById(id);
    }

    @Async
    @Override
    public Future<Page<User>> getAllNotApprovedProviders(Pageable pageable)
    {
        return new AsyncResult<>(repo.getAllByProvider_isApproved(false, pageable));
    }

    @Async
    @Override
    public Future<Page<User>> getAllByName(String name, Pageable pageable)
    {
        return new AsyncResult<>(
                repo.findAllByProvider_isApprovedAndProvider_CompanyNameContainingIgnoreCase(true, name, pageable));
    }

}
