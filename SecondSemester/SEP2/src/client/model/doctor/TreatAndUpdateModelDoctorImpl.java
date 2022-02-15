package client.model.doctor;

import client.networking.doctor.TreatAndUpdateClientDoctor;
import shared.Diagnosis;
import shared.Doctor;
import shared.Patient;
import shared.Treatment;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * The class responsible for the functions of the Doctor(User) for managing patients treatments and diagnosis
 */
public class TreatAndUpdateModelDoctorImpl implements TreatAndUpdateModelDoctor
{
  private TreatAndUpdateClientDoctor clientDoctor;

  /**
   * Constructor where the corresponding client is passed as argument
   * @param client argument, which will be assigned to the private field variable
   */
  public TreatAndUpdateModelDoctorImpl(Object client)
  {
    clientDoctor = (TreatAndUpdateClientDoctor) client;
  }

  /**
   * Adds diagnosis to a specific patient in the database through the MVVM layers
   * @param patient the patient to whom the diagnosis belongs
   * @param diagnosis the object containing the diagnosis data
   */
  @Override public void addDiagnosisToPatient(Patient patient,
      Diagnosis diagnosis)
  {
    try
    {
      clientDoctor.addDiagnosisToPatient(patient, diagnosis);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(
          "Error while adding patient diagnosis. Please try again.");
    }
  }

  /**
   * Adds treatment to a patient in the database through the MVVM layers
   * @param patient the patient to whom the treatment belongs
   * @param diagnosis the diagnosis the treatment refers to
   * @param doctor the doctor issuing the tretment
   * @param treatment the treatment details
   */
  @Override public void treatPatient(Patient patient, Diagnosis diagnosis,
      Doctor doctor, Treatment treatment)
  {
    try
    {
      clientDoctor.treatPatient(patient, diagnosis, doctor, treatment);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(
          "Error while adding patient treatment. Please try again.");
    }
  }

  /**
   * Gets all the diagnosis of a specific patient
   * @param patient the patient whose diagnosis are required
   * @return ArrayList of Diagnosis objects
   */
  @Override public ArrayList<Diagnosis> getAllDiagnosisOfPatient(
      Patient patient)
  {
    try
    {
      return clientDoctor.getAllDiseasesOfPatient(patient);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(
          "Error while fetching patient data. Please try again.");
    }
  }

  /**
   * Edit a diagnosis of already existing Diagnosis object
   * @param diagnosis the edited diagnosis
   */
  @Override public void editDiagnosis(Diagnosis diagnosis)
  {
    try
    {
      clientDoctor.editDiagnosis(diagnosis);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(
          "Error while fetching patient data. Please try again.");
    }
  }

  /**
   * Gets all the treatments assigned to a patient
   * @param patient the patient whose treatments has to be fetched
   * @param doctor the doctor performing the treatment
   * @return ArrayList of Treatment objects
   */
  @Override public ArrayList<Treatment> getAllTreatmentsOfPatient(
      Patient patient, Doctor doctor)
  {
    try
    {
      return clientDoctor.getAllTreatmentsOfPatient(patient, doctor);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(
          "Error while fetching patient treatments. Please try again.");
    }
  }
}
