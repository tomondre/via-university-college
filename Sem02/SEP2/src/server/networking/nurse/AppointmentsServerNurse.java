package server.networking.nurse;

import shared.Appointment;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AppointmentsServerNurse extends Remote
{
    void createAppointment(Appointment appointment) throws RemoteException;
    void removeAppointment(Appointment appointment) throws RemoteException;
}
