package client.model.nurse;

import client.networking.nurse.AppointmentsClientNurse;
import shared.Appointment;

import java.rmi.RemoteException;

/**
 * Class containing methods the Nurse(User) need to manage the appointments
 */
public class AppointmentsModelNurseImpl implements AppointmentsModelNurse
{
    private AppointmentsClientNurse clientNurse;

    /**
     * Constructor where the corresponding client is passed as an argument
     * @param client argument, which will be assigned to the local private field
     */
    public AppointmentsModelNurseImpl(Object client)
    {
        clientNurse = (AppointmentsClientNurse) client;
    }

    /**
     * Adds an appointment to the database through the MVVM layers
     * @param appointment the object containing the appointment data
     */
    @Override
    public void createAppointment(Appointment appointment)
    {
        try
        {
            clientNurse.createAppointment(appointment);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while creating appointment. Please try again.");
        }
    }

    /**
     * Removes appointment from the database through the MVVM layers
     * @param appointment the appointment to remove
     */
    @Override
    public void removeAppointment(Appointment appointment)
    {
        try
        {
            clientNurse.removeAppointment(appointment);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while editing appointment. Please try again.");
        }
    }
}
