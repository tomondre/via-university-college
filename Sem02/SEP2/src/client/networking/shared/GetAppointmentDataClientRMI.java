package client.networking.shared;

import server.networking.shared.GetAppointmentDataServer;
import shared.Appointment;
import shared.Doctor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class GetAppointmentDataClientRMI implements GetAppointmentDataClient
{
    private GetAppointmentDataServer sharedServer;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public GetAppointmentDataClientRMI()
    {
        try
        {
            Registry registry = LocateRegistry.getRegistry(1099);
            sharedServer = (GetAppointmentDataServer) registry.lookup("GetAppointmentDataServer");
        }
        catch (RemoteException | NotBoundException e)
        {
            throw new RuntimeException("Could not connect to the server, please try again later.");
        }
    }

    @Override
    public ArrayList<Appointment> getAllAppointments()
    {
        try
        {
            return sharedServer.getAllAppointments();
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while fetching all appointments. Please try again.");
        }
    }

    @Override
    public ArrayList<Appointment> getAppointmentsForDoctor(Doctor doctor)
    {
        try
        {
            return sharedServer.getAppointmentsForDoctor(doctor);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while fetching all appointments. Please try again.");
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
