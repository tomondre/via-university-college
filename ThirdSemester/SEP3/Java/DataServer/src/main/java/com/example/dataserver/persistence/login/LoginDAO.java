package com.example.dataserver.persistence.login;

import com.example.dataserver.models.User;

import java.util.concurrent.Future;

/**
 * Interface for logging in of user
 */
public interface LoginDAO
{
  /**
   * Method for getting user
   * @param userCred credentials to be checked
   * @return future asynchronous result containing logged-in user
   */
  Future<User> getUserLogin(User userCred);
}
