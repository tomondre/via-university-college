package server.database.manager;

import shared.Doctor;
import shared.Nurse;

import java.util.ArrayList;

public interface EmployeeDBAccessManager
{
    String addDoctor(Doctor doctor);
    String addNurse(Nurse nurse);
    String editDoctor(Doctor doctor);
    String editNurse(Nurse nurse);
    String removeDoctor(Doctor doctor);
    String removeNurse(Nurse nurse);
}
