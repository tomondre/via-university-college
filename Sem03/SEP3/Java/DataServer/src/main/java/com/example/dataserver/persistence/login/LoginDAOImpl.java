package com.example.dataserver.persistence.login;

import com.example.dataserver.models.User;
import com.example.dataserver.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;

import java.util.concurrent.Future;

@Repository
@EnableAsync
public class LoginDAOImpl implements LoginDAO
{
  private UserRepository repository;

  @Autowired
  public LoginDAOImpl(UserRepository repository)
  {
    this.repository = repository;
  }

  @Async
  @Override
  public Future<User> getUserLogin(User userCred)
  {
    return new AsyncResult<>(repository.getUserByEmailAndPassword(userCred.getEmail(),
                                                                  userCred.getPassword()));
  }
}
