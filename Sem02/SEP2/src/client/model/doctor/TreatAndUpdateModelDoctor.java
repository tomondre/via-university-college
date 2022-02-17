package client.model.doctor;

import shared.Diagnosis;
import shared.Doctor;
import shared.Patient;
import shared.Treatment;

import java.util.ArrayList;

public interface TreatAndUpdateModelDoctor
{
  void addDiagnosisToPatient(Patient patient, Diagnosis diagnosis);
  void treatPatient(Patient patient, Diagnosis diagnosis, Doctor doctor, Treatment treatment);
  ArrayList<Diagnosis> getAllDiagnosisOfPatient(Patient patient);
  void editDiagnosis(Diagnosis diagnosis);
  ArrayList<Treatment> getAllTreatmentsOfPatient(Patient patient, Doctor doctor);
}
