package client.model.shared;

import shared.Doctor;
import shared.Nurse;
import shared.util.PropertyChangeSubject;

import java.util.ArrayList;

public interface GetEmployeeDataModel
{
    ArrayList<Doctor> getListOfAllDoctors();
    ArrayList<Nurse> getListOfAllNurses();
    Doctor getDoctorBySSN(long ssn);
    Nurse getNurseBySSN(long ssn);
}
