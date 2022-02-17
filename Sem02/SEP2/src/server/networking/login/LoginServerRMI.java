package server.networking.login;

import server.model.login.LoginServerModel;
import server.model.login.LoginServerModelImpl;
import shared.AccessType;
import shared.LoginUser;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class LoginServerRMI implements LoginServer
{
    private LoginServerModel loginServerModel;

    public LoginServerRMI(Registry registry) throws RemoteException, AlreadyBoundException
    {
        loginServerModel = new LoginServerModelImpl();
        UnicastRemoteObject.exportObject(this, 0);
        startServer(registry);
    }

    private void startServer(Registry registry) throws AlreadyBoundException, RemoteException
    {
        registry.bind("LoginServer", this);
        System.out.println("LoginServer is running.");
    }

    @Override
    public synchronized AccessType login(LoginUser user)
    {
        return loginServerModel.login(user);
    }
}
