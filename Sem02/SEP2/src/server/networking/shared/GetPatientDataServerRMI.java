package server.networking.shared;

import server.model.shared.GetPatientDataServerModel;
import server.model.shared.GetPatientDataServerModelImpl;
import shared.Patient;
import shared.Sample;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class GetPatientDataServerRMI implements GetPatientDataServer
{
    private GetPatientDataServerModel sharedServerModel;

    public GetPatientDataServerRMI(Registry registry) throws AlreadyBoundException, RemoteException
    {
        sharedServerModel = new GetPatientDataServerModelImpl();
        UnicastRemoteObject.exportObject(this, 0);
        startServer(registry);
    }

    private void startServer(Registry registry) throws AlreadyBoundException, RemoteException
    {
        registry.bind("GetPatientDataServer", this);
        System.out.println("GetPatientDataServer is running.");
    }

    @Override
    public synchronized ArrayList<Patient> getAllPatients()
    {
        return sharedServerModel.getAllPatients();
    }

    @Override
    public synchronized Patient getPatientBySSN(long ssn)
    {
        return sharedServerModel.getPatientBySSN(ssn);
    }

    @Override
    public synchronized ArrayList<Sample> getPatientSample(long ssn)
    {
        return sharedServerModel.getPatientSample(ssn);
    }
}
