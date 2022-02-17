package client.networking.shared;

import shared.Appointment;
import shared.Doctor;
import shared.util.PropertyChangeSubject;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GetAppointmentDataClient extends Remote, PropertyChangeSubject
{
    ArrayList<Appointment> getAllAppointments() throws RemoteException;
    ArrayList<Appointment> getAppointmentsForDoctor(Doctor doctor) throws RemoteException;
}
