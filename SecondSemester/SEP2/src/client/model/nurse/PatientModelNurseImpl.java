package client.model.nurse;


import client.networking.nurse.PatientClientNurse;
import shared.Patient;

import java.rmi.RemoteException;

/**
 * Class containing methods the Nurse(User) need to manage the patients
 */
public class PatientModelNurseImpl implements PatientModelNurse
{
    private PatientClientNurse clientNurse;

    /**
     * Constructor where the corresponding client is passed as an argument
     * @param client argument, which will be assigned to the local private field
     */
    public PatientModelNurseImpl(Object client)
    {
        clientNurse = (PatientClientNurse) client;
    }

    /**
     * Adds patient to the database through the MVVM layers
     * @param patient the object containing the patient data
     */
    @Override
    public void addPatient(Patient patient)
    {
        try
        {
            clientNurse.addPatient(patient);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while adding patient. Please try again.");
        }
    }

    /**
     * Edits already existing patient in the database through the MVVM layers
     * @param patient the edited patient object
     */
    @Override
    public void editPatient(Patient patient)
    {
        try
        {
            clientNurse.editPatient(patient);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while editing patient. Please try again.");
        }
    }

    /**
     * Removes already existing patient from the database through the MVVM layers
     * @param patient the patient object ot remove
     */
    @Override
    public void removePatient(Patient patient)
    {
        try
        {
            clientNurse.removePatient(patient);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while removing patient. Please try again.");
        }
    }

}
