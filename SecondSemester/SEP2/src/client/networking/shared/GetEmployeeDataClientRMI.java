package client.networking.shared;

import server.networking.shared.GetEmployeeDataServer;
import shared.Doctor;
import shared.Nurse;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class GetEmployeeDataClientRMI implements GetEmployeeDataClient
{
    private GetEmployeeDataServer sharedServer;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public GetEmployeeDataClientRMI()
    {
        try
        {
            Registry registry = LocateRegistry.getRegistry(1099);
            sharedServer = (GetEmployeeDataServer) registry.lookup("GetEmployeeDataServer");
        }
        catch (RemoteException | NotBoundException e)
        {
            throw new RuntimeException("Could not connect to the server, please try again later.");
        }
    }

    @Override
    public ArrayList<Doctor> getListOfAllDoctors()
    {
        try
        {
            return sharedServer.getListOfAllDoctors();
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while fetching all doctors from the system. Please try again.");
        }
    }

    @Override
    public ArrayList<Nurse> getListOfAllNurses()
    {
        try
        {
            return sharedServer.getListOfAllNurses();
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while fetching all nurses from the system. Please try again.");
        }
    }

    @Override
    public Doctor getDoctorBySSN(long ssn)
    {
        try
        {
            return sharedServer.getDoctorBySSN(ssn);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while fetching doctor from the system. Please try again.");
        }
    }

    @Override
    public Nurse getNurseBySSN(long ssn)
    {
        try
        {
            return sharedServer.getNurseBySSN(ssn);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while fetching nurse from the system. Please try again.");
        }
    }



    @Override
    public void addPropertyChangeListener(String name, PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(name, listener);
    }

    @Override
    public void removePropertyChangeListener(String name, PropertyChangeListener listener)
    {
        support.removePropertyChangeListener(name, listener);
    }


}
