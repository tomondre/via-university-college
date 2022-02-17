package client.networking.shared;

import shared.Patient;
import shared.Sample;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GetPatientDataClient extends Remote
{
  ArrayList<Patient> getAllPatients() throws RemoteException;
  Patient getPatientBySSN(long ssn) throws RemoteException;
  ArrayList<Sample> getPatientSamples(long ssn) throws RemoteException;
}
