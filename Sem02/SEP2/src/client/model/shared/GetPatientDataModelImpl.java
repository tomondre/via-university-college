package client.model.shared;

import client.networking.shared.GetPatientDataClient;
import shared.Patient;
import shared.Sample;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Class containing methods the Users need to fetch data for the patients
 */
public class GetPatientDataModelImpl implements GetPatientDataModel
{
    private GetPatientDataClient sharedClient;

    /**
     * Constructor where the corresponding client is passed as an argument
     * @param client argument, which will be assigned to the local private field
     */
    public GetPatientDataModelImpl(Object client)
    {
        sharedClient = (GetPatientDataClient) client;
    }

    /**
     * Gets all the patients from the database through the MVVM layers
     * @return ArrayList of Patient objects
     */
    @Override
    public ArrayList<Patient> getAllPatients()
    {
        try
        {
            return sharedClient.getAllPatients();
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while fetching all patients. Please try again.");
        }
    }

    /**
     * Gets a specific patient from the database trough the MVVM layers
     * @param ssn the ssn of the required patient
     * @return Patient object
     */
    @Override
    public Patient getPatientBySSN(long ssn)
    {
        try
        {
            return sharedClient.getPatientBySSN(ssn);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while fetching patient. Please try again.");
        }
    }

    /**
     * Gets all the samples of a specific patient
     * @param ssn the ssn of the required patient
     * @return ArrayList of Sample objects
     */
    @Override public ArrayList<Sample> getPatientSamples(long ssn)
    {
        try
        {
            return sharedClient.getPatientSamples(ssn);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while fetching samples. Please try again.");
        }
    }
}
