package client.model.nurse;

import shared.Patient;

public interface PatientModelNurse
{
  void addPatient(Patient patient);
  void editPatient(Patient patient);
  void removePatient(Patient patient);
}
