package server.networking.shared;

import server.model.shared.GetAppointmentDataServerModel;
import server.model.shared.GetAppointmentDataServerModelImpl;
import shared.Appointment;
import shared.Doctor;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class GetAppointmentDataServerRMI implements GetAppointmentDataServer
{
    private GetAppointmentDataServerModel sharedServerModel;

    public GetAppointmentDataServerRMI(Registry registry) throws AlreadyBoundException, RemoteException
    {
        sharedServerModel = new GetAppointmentDataServerModelImpl();
        UnicastRemoteObject.exportObject(this, 0);
        startServer(registry);
    }

    private void startServer(Registry registry) throws AlreadyBoundException, RemoteException
    {
        registry.bind("GetAppointmentDataServer", this);
        System.out.println("GetAppointmentDataServer is running.");
    }

    @Override
    public synchronized ArrayList<Appointment> getAllAppointments()
    {
        return sharedServerModel.getAllAppointments();
    }

    @Override
    public synchronized ArrayList<Appointment> getAppointmentsForDoctor(Doctor doctor)
    {
        return sharedServerModel.getAppointmentsForDoctor(doctor);
    }
}
