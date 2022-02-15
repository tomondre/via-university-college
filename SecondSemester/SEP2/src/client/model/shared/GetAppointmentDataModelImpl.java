package client.model.shared;

import client.networking.shared.GetAppointmentDataClient;
import shared.Appointment;
import shared.Doctor;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Class containing methods the Users need to fetch data for the appointments
 */
public class GetAppointmentDataModelImpl implements GetAppointmentDataModel
{
    private GetAppointmentDataClient sharedClient;

    /**
     * Constructor where the corresponding client is passed as an argument
     * @param client argument, which will be assigned to the local private field
     */
    public GetAppointmentDataModelImpl(Object client)
    {
        sharedClient = (GetAppointmentDataClient) client;
    }

    /**
     * Gets all the appointments from the database through the MVVM layers
     * @return ArrayList of Appointment objects
     */
    @Override
    public ArrayList<Appointment> getAllAppointments()
    {
        try
        {
            return sharedClient.getAllAppointments();
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while fetching all appointments. Please try again.");
        }
    }

    /**
     * Gets all appointments assigned to a doctor through the MVVM layers
     * @param doctor the doctor whose appointment need to be fetched
     * @return ArrayList of Appointment objects
     */
    @Override
    public ArrayList<Appointment> getAppointmentsForDoctor(Doctor doctor)
    {
        try
        {
            return sharedClient.getAppointmentsForDoctor(doctor);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while fetching all appointments. Please try again.");
        }
    }
}
