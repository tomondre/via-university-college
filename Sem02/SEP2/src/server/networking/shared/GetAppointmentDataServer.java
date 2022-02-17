package server.networking.shared;

import shared.Appointment;
import shared.Doctor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GetAppointmentDataServer extends Remote
{
    ArrayList<Appointment> getAllAppointments() throws RemoteException;
    ArrayList<Appointment> getAppointmentsForDoctor(Doctor doctor) throws RemoteException;
}
