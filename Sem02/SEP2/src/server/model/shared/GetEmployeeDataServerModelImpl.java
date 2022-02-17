package server.model.shared;

import server.database.shared.GetEmployeeDataDBAccess;
import server.database.shared.GetEmployeeDataDBAccessImpl;
import shared.Doctor;
import shared.Nurse;

import java.util.ArrayList;

public class GetEmployeeDataServerModelImpl implements GetEmployeeDataServerModel
{
    private GetEmployeeDataDBAccess sharedDBAccess;

    public GetEmployeeDataServerModelImpl()
    {
        sharedDBAccess = new GetEmployeeDataDBAccessImpl();
    }

    @Override
    public ArrayList<Doctor> getListOfAllDoctors()
    {
        return sharedDBAccess.getListOfAllDoctors();
    }

    @Override
    public ArrayList<Nurse> getListOfAllNurses()
    {
        return sharedDBAccess.getListOfAllNurses();
    }

    @Override
    public Doctor getDoctorBySSN(long ssn)
    {
        return sharedDBAccess.getDoctorBySSN(ssn);
    }

    @Override
    public Nurse getNurseBySSN(long ssn)
    {
        return sharedDBAccess.getNurseBySSN(ssn);
    }
}
