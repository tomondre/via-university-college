package client.networking.login;

import server.networking.login.LoginServer;
import shared.AccessType;
import shared.LoginUser;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class LoginClientImpl implements LoginClient
{
    private LoginServer loginServer;

  public LoginClientImpl()
  {
    try
    {
      Registry registry = LocateRegistry.getRegistry(1099);
      loginServer = (LoginServer) registry.lookup("LoginServer");
    }
    catch (RemoteException | NotBoundException e)
    {
      throw new RuntimeException("Could not connect to the server, the login failed.");
    }
  }

  @Override
    public AccessType login(LoginUser user)
    {
      try
      {
        return loginServer.login(user);
      }
      catch (RemoteException e)
      {
        throw new RuntimeException("Error while logging in. Please try again.");
      }
    }
}
