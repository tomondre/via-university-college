package client.model.shared;

import client.networking.shared.GetEmployeeDataClient;
import shared.Doctor;
import shared.Nurse;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Class containing methods the Users need to fetch data for the employees
 */
public class GetEmployeeDataModelImpl implements GetEmployeeDataModel
{
    private GetEmployeeDataClient sharedClient;

    /**
     * Constructor where the corresponding client is passed as an argument
     * @param client argument, which will be assigned to the local private field
     */
    public GetEmployeeDataModelImpl(Object client)
    {
        sharedClient = (GetEmployeeDataClient) client;
    }

    /**
     * Gets all doctors from the database through the MVVM layers
     * @return ArrayList of Doctor objects
     */
    @Override
    public ArrayList<Doctor> getListOfAllDoctors()
    {
        try
        {
            return sharedClient.getListOfAllDoctors();
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while fetching all doctors from the system. Please try again.");
        }
    }

    /**
     * Gets all nurses from the database through the MVVM layers
     * @return ArrayList of Nurse objects
     */
    @Override
    public ArrayList<Nurse> getListOfAllNurses()
    {
        try
        {
            return sharedClient.getListOfAllNurses();
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while fetching all nurses from the system. Please try again.");
        }
    }

    /**
     * Gets a specific doctor from the database trough the MVVM layers
     * @param ssn the ssn of the required doctor
     * @return Doctor object
     */
    @Override
    public Doctor getDoctorBySSN(long ssn)
    {
        try
        {
            return sharedClient.getDoctorBySSN(ssn);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while fetching doctor from the system. Please try again.");

        }
    }

    /**
     * Gets a specific nurse from the database trough the MVVM layers
     * @param ssn the ssn of the required nurse
     * @return Nurse object
     */
    @Override
    public Nurse getNurseBySSN(long ssn)
    {
        try
        {
            return sharedClient.getNurseBySSN(ssn);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while fetching nurse from the system. Please try again.");

        }
    }
}
