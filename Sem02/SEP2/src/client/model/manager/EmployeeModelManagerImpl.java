package client.model.manager;

import client.networking.manager.EmployeeClientManager;
import shared.Doctor;
import shared.Nurse;

import java.rmi.RemoteException;

/**
 * Class containing methods the Manager(User) need to manage the employees
 */
public class EmployeeModelManagerImpl implements EmployeeModelManager
{
    private EmployeeClientManager clientManager;

    /**
     * Constructor where the corresponding client is passed as an argument
     * @param client argument, which will be assigned to the local private field
     */
    public EmployeeModelManagerImpl(Object client)
    {
        clientManager = (EmployeeClientManager) client;
    }

    /**
     * Adds a doctor to the database through the MVVM layers
     * @param doctor the object containing the doctors data
     * @return null. For the future will return the data that was stored successfully to the database
     */
    @Override
    public String addDoctor(Doctor doctor)
    {
        try
        {
            return clientManager.addDoctor(doctor);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while adding doctor to the system. Please try again.");
        }
    }

    /**
     * Adds a nurse to the database through the MVVM layers
     * @param nurse the object containing the nurses data
     * @return null. For the future will return the changes made to the database
     */
    @Override
    public String addNurse(Nurse nurse)
    {
        try
        {
            return clientManager.addNurse(nurse);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while adding nurse to the system. Please try again.");
        }
    }

    /**
     * Edits already existing doctor in the database through the MVVM layers
     * @param doctor the object containing the doctors data
     * @return null. For the future will return the changes made to the database
     */
    @Override
    public String editDoctor(Doctor doctor)
    {
        try
        {
            return clientManager.editDoctor(doctor);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while editing doctor to the system. Please try again.");
        }
    }

    /**
     * Edits a nurse in the database through the MVVM layers
     * @param nurse the object containing the nurses data
     * @return null. For the future will return the changes made to the database
     */
    @Override
    public String editNurse(Nurse nurse)
    {
        try
        {
            return clientManager.editNurse(nurse);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while editing nurse to the system. Please try again.");
        }
    }

    /**
     * Removes already existing doctor from the database through the MVVM layers
     * @param doctor the object containing the doctors data
     * @return null. For the future will return the changes made to the database
     */
    @Override
    public String removeDoctor(Doctor doctor)
    {
        try
        {
            return clientManager.removeDoctor(doctor);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while removing doctor from the system. Please try again.");
        }
    }

    /**
     * Removes a nurse from the database through the MVVM layers
     * @param nurse the object containing the nurses data
     * @return null. For the future will return the changes made to the database
     */
    @Override
    public String removeNurse(Nurse nurse)
    {
        try
        {
            return clientManager.removeNurse(nurse);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while removing nurse from the system. Please try again.");
        }
    }
}
