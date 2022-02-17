package server.model.doctor;

import shared.Diagnosis;
import shared.Doctor;
import shared.Patient;
import shared.Treatment;

import java.util.ArrayList;

public interface TreatAndUpdateServerModelDoctor
{
    void addDiagnosisToPatient(Patient patient, Diagnosis diagnosis);
    void treatPatient(Patient patient, Diagnosis diagnosis, Doctor doctor, Treatment treatment);
    ArrayList<Diagnosis> getAllDiseasesOfPatient(Patient patient);
    void editDiagnosis(Diagnosis diagnosis);
  ArrayList<Treatment> getAllTreatmentsOfPatient(Patient patient, Doctor doctor);
}
