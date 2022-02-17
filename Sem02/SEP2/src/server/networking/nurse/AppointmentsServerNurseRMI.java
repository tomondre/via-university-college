package server.networking.nurse;

import server.model.nurse.AppointmentsServerModelNurse;
import server.model.nurse.AppointmentsServerModelNurseImpl;
import shared.Appointment;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class AppointmentsServerNurseRMI implements AppointmentsServerNurse
{
    private AppointmentsServerModelNurse modelNurse;

    public AppointmentsServerNurseRMI(Registry registry) throws AlreadyBoundException, RemoteException
    {
        modelNurse = new AppointmentsServerModelNurseImpl();
        UnicastRemoteObject.exportObject(this, 0);
        startServer(registry);
    }

    private void startServer(Registry registry) throws AlreadyBoundException, RemoteException
    {
        registry.bind("AppointmentServerNurse", this);
        System.out.println("AppointmentServerNurse is running.");
    }

    @Override
    public synchronized void createAppointment(Appointment appointment)
    {
        modelNurse.createAppointment(appointment);
    }

    @Override
    public synchronized void removeAppointment(Appointment appointment)
    {
        modelNurse.removeAppointment(appointment);
    }
}
