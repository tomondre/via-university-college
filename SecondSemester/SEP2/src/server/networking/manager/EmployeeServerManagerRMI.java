package server.networking.manager;

import server.model.manager.EmployeeServerModelManager;
import server.model.manager.EmployeeServerModelManagerImpl;
import shared.Doctor;
import shared.Nurse;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class EmployeeServerManagerRMI implements EmployeeServerManager
{
    private EmployeeServerModelManager modelManager;

    public EmployeeServerManagerRMI(Registry registry) throws AlreadyBoundException, RemoteException
    {
        modelManager = new EmployeeServerModelManagerImpl();
        UnicastRemoteObject.exportObject(this, 0);
        startServer(registry);
    }

    private void startServer(Registry registry) throws AlreadyBoundException, RemoteException
    {
        registry.bind("EmployeeServerManager", this);
        System.out.println("EmployeeServerManager is running.");
    }

    @Override
    public synchronized String addDoctor(Doctor doctor)
    {
        return modelManager.addDoctor(doctor);
    }

    @Override
    public synchronized String addNurse(Nurse nurse)
    {
        return modelManager.addNurse(nurse);
    }

    @Override
    public synchronized String editDoctor(Doctor doctor)
    {
        return modelManager.editDoctor(doctor);
    }

    @Override
    public synchronized String editNurse(Nurse nurse)
    {
        return modelManager.editNurse(nurse);
    }

    @Override
    public synchronized String removeDoctor(Doctor doctor)
    {
        return modelManager.removeDoctor(doctor);
    }

    @Override
    public synchronized String removeNurse(Nurse nurse)
    {
        return modelManager.removeNurse(nurse);
    }
}
