package client.networking.doctor;

import shared.Patient;
import shared.Sample;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface SampleClientDoctor extends Remote
{
  ArrayList<Sample> getAllSamples() throws RemoteException;
  void createSample(Sample sample) throws RemoteException;
  void editSample(Sample sample) throws RemoteException;
  Sample getSampleByID(int id) throws RemoteException;
  ArrayList<Sample> getAllPatientSamples(Patient patient) throws RemoteException;
}
