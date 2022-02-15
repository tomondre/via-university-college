package server.database.nurse;

import shared.Patient;

public interface PatientDBAccessNurse
{
    void addPatient(Patient patient);
    void editPatient(Patient patient);
    void removePatient(Patient patient);
}
