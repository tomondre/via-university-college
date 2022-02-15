package client.model.doctor;

import client.networking.doctor.SampleClientDoctor;
import shared.Patient;
import shared.Sample;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * The class responsible for the functions of the Doctor(User) for managing patients samples
 */
public class SampleModelDoctorImpl implements SampleModelDoctor
{
  private SampleClientDoctor clientDoctor;

  /**
   * Constructor where the corresponding client is passed as an argument
   * @param client argument, which will be assigned to the local private field
   */
  public SampleModelDoctorImpl(Object client)
  {
    clientDoctor = (SampleClientDoctor) client;
  }

  /**
   * Gets all the samples from the database through the MVVM layers
   * @return ArrayList of Sample objects
   */
  @Override public ArrayList<Sample> getAllSamples()
  {
    try
    {
      return clientDoctor.getAllSamples();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while fetching all samples. Please try again.");
    }
  }

  /**
   * Saves sample to the database thought the MVVM layers
   * @param sample object containing the data for creating a sample
   */
  @Override public void createSample(Sample sample)
  {
    try
    {
      clientDoctor.createSample(sample);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while creating sample. Please try again.");
    }
  }

  /**
   * Edits an existing sample in the database through the MVVM layers
   * @param sample the object contain the edited data
   */
  @Override public void editSample(Sample sample)
  {
    try
    {
      clientDoctor.editSample(sample);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while editing sample. Please try again.");
    }
  }

  /**
   * Gets sample by the generated id in the database
   * @param id the int from already created sample
   * @return Sample object
   */
  @Override public Sample getSampleByID(int id)
  {
    try
    {
      return clientDoctor.getSampleByID(id);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while fetching sample. Please try again.");
    }
  }

  /**
   * Gets all the samples assigned to a patient
   * @param patient the patient whose samples has to be fetched
   * @return ArrayList of Sample objects
   */
  @Override public ArrayList<Sample> getAllPatientSamples(Patient patient)
  {
    try
    {
      return clientDoctor.getAllPatientSamples(patient);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while fetching samples. Please try again.");
    }
  }
}
