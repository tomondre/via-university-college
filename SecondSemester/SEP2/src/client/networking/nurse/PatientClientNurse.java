package client.networking.nurse;

import shared.Patient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PatientClientNurse extends Remote
{
  void addPatient(Patient patient) throws RemoteException;
  void editPatient(Patient patient) throws RemoteException;
  void removePatient(Patient patient) throws RemoteException;

}
