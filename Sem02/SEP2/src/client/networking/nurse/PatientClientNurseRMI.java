package client.networking.nurse;

import server.networking.nurse.PatientServerNurse;
import shared.Patient;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PatientClientNurseRMI implements PatientClientNurse
{
    private PatientServerNurse serverNurse;

    public PatientClientNurseRMI()
    {
        try
        {
            Registry registry = LocateRegistry.getRegistry(1099);
            serverNurse = (PatientServerNurse) registry.lookup("PatientServerNurse");
        }
        catch (RemoteException | NotBoundException e)
        {
            throw new RuntimeException("Could not connect to the server, please try again later.");
        }
    }

    @Override
    public void addPatient(Patient patient)
    {
      try
      {
        serverNurse.addPatient(patient);
      }
      catch (RemoteException e)
      {
        throw new RuntimeException("Error while adding patient. Please try again.");
      }
    }

    @Override
    public void editPatient(Patient patient)
    {
      try
      {
        serverNurse.editPatient(patient);
      }
      catch (RemoteException e)
      {
        throw new RuntimeException("Error while editing patient. Please try again.");
      }
    }

    @Override
    public void removePatient(Patient patient)
    {
      try
      {
        serverNurse.removePatient(patient);
      }
      catch (RemoteException e)
      {
        throw new RuntimeException("Error while removing patient. Please try again.");
      }
    }
}
