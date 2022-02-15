package client.networking.doctor;

import server.networking.doctor.SampleServerDoctor;
import shared.Patient;
import shared.Sample;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class SampleClientDoctorRMI implements SampleClientDoctor
{
  private SampleServerDoctor serverDoctor;

  public SampleClientDoctorRMI()
  {
    try
    {
      Registry registry = LocateRegistry.getRegistry(1099);
      serverDoctor = (SampleServerDoctor) registry.lookup("SampleServerDoctor");
    }
    catch (RemoteException | NotBoundException e)
    {
      throw new RuntimeException("Could not connect to the server, please try again later");
    }
  }

  @Override public ArrayList<Sample> getAllSamples()
  {
    try
    {
      return serverDoctor.getAllSamples();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while fetching all samples. Please try again.");
    }
  }

  @Override public void createSample(Sample sample)
  {
    try
    {
      serverDoctor.createSample(sample);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while creating sample. Please try again.");
    }
  }

  @Override public void editSample(Sample sample)
  {
    try
    {
      serverDoctor.editSample(sample);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while editing sample. Please try again.");
    }
  }

  @Override public Sample getSampleByID(int id)
  {
    try
    {
      return serverDoctor.getSampleById(id);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while fetching sample. Please try again.");
    }
  }

  @Override public ArrayList<Sample> getAllPatientSamples(Patient patient)
  {
    try
    {
      return serverDoctor.getAllPatientSamples(patient);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while fetching samples. Please try again.");
    }
  }
}
