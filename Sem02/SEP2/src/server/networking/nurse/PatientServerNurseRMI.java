package server.networking.nurse;

import server.model.nurse.PatientServerModelNurse;
import server.model.nurse.PatientServerModelNurseImpl;
import shared.Patient;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class PatientServerNurseRMI implements PatientServerNurse
{
    private PatientServerModelNurse modelNurse;

    public PatientServerNurseRMI(Registry registry) throws AlreadyBoundException, RemoteException
    {
        modelNurse = new PatientServerModelNurseImpl();
        UnicastRemoteObject.exportObject(this, 0);
        startServer(registry);
    }

    private void startServer(Registry registry) throws AlreadyBoundException, RemoteException
    {
        registry.bind("PatientServerNurse", this);
        System.out.println("PatientServerNurse is running.");
    }

    @Override
    public synchronized void addPatient(Patient patient)
    {
        modelNurse.addPatient(patient);
    }

    @Override
    public synchronized void editPatient(Patient patient)
    {
        modelNurse.editPatient(patient);
    }

    @Override
    public synchronized void removePatient(Patient patient)
    {
        modelNurse.removePatient(patient);
    }
}
