package server.model.nurse;

import shared.Patient;

public interface PatientServerModelNurse
{
    void addPatient(Patient patient);
    void editPatient(Patient patient);
    void removePatient(Patient patient);
}
