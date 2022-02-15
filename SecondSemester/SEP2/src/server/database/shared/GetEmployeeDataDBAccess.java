package server.database.shared;

import shared.Doctor;
import shared.Nurse;

import java.util.ArrayList;

public interface GetEmployeeDataDBAccess
{
    ArrayList<Doctor> getListOfAllDoctors();
    ArrayList<Nurse> getListOfAllNurses();
    Doctor getDoctorBySSN(long ssn);
    Nurse getNurseBySSN(long ssn);
}
