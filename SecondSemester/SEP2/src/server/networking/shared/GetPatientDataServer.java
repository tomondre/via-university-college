package server.networking.shared;

import shared.Patient;
import shared.Sample;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GetPatientDataServer extends Remote
{
    ArrayList<Patient> getAllPatients() throws RemoteException;
    Patient getPatientBySSN(long ssn) throws RemoteException;
  ArrayList<Sample> getPatientSample(long ssn) throws RemoteException;
}
