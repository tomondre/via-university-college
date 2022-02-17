package server.networking.manager;

import server.model.manager.WardServerModelManager;
import server.model.manager.WardServerModelManagerImpl;
import shared.Ward;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class WardServerManagerRMI implements WardServerManager
{
    private WardServerModelManager modelManager;

    public WardServerManagerRMI(Registry registry) throws AlreadyBoundException, RemoteException
    {
        modelManager = new WardServerModelManagerImpl();
        UnicastRemoteObject.exportObject(this, 0);
        startServer(registry);
    }

    private void startServer(Registry registry) throws AlreadyBoundException, RemoteException
    {
        registry.bind("WardServerManager", this);
        System.out.println("WardServerManager is running");
    }

    @Override
    public synchronized void addWard(Ward ward)
    {
        modelManager.addWard(ward);
    }

    @Override
    public synchronized void editWard(Ward oldWard, Ward newWard)
    {
        modelManager.editWard(oldWard, newWard);
    }

    @Override
    public synchronized void removeWard(Ward ward)
    {
        modelManager.removeWard(ward);
    }

    @Override
    public synchronized ArrayList<Ward> getAllWards()
    {
        return modelManager.getAllWards();
    }
}
