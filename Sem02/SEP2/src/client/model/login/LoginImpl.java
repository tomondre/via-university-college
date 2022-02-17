package client.model.login;

import client.networking.login.LoginClient;
import shared.AccessType;
import shared.LoginUser;

import java.rmi.RemoteException;

/**
 * Class responsible for verifying the user data are correct
 */
public class LoginImpl implements Login
{
  private LoginClient loginClient;

  public LoginImpl(Object client)
  {
    loginClient = (LoginClient) client;
  }

  /**
   * Checks if the user exists in the database trough the MVVM layers
   * @param user contains the username, password and AccessType of the user wishing to login
   * @return the AccessType of the user. NO_ACCESS prevents the login
   */
  @Override public AccessType login(LoginUser user)
  {
    try
    {
      return loginClient.login(user);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while logging in. Please try again.");
    }
  }
}
