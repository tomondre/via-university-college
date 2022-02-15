package client.networking.shared;

import server.networking.shared.GetEmployeeDataServer;
import server.networking.shared.GetPatientDataServer;
import shared.Patient;
import shared.Sample;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class GetPatientDataClientRMI implements GetPatientDataClient
{
    private GetPatientDataServer sharedServer;

    public GetPatientDataClientRMI()
    {
        try
        {
            Registry registry = LocateRegistry.getRegistry(1099);
            sharedServer = (GetPatientDataServer) registry.lookup("GetPatientDataServer");
        }
        catch (RemoteException | NotBoundException e)
        {
            throw new RuntimeException("Could not connect to the server, please try again later.");
        }
    }

    @Override
    public ArrayList<Patient> getAllPatients()
    {
        try
        {
            return sharedServer.getAllPatients();
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while fetching all patients. Please try again.");
        }
    }

    @Override
    public Patient getPatientBySSN(long ssn)
    {
        try
        {
            return sharedServer.getPatientBySSN(ssn);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while fetching patient. Please try again.");
        }
    }

    @Override public ArrayList<Sample> getPatientSamples(long ssn)
    {
        try
        {
            return sharedServer.getPatientSample(ssn);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException("Error while fetching samples. Please try again.");
        }
    }
}
