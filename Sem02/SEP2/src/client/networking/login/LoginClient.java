package client.networking.login;

import shared.AccessType;
import shared.LoginUser;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginClient extends Remote
{
    AccessType login(LoginUser user) throws RemoteException;
}
