package server.model.shared;

import server.database.shared.GetAppointmentDataDBAccess;
import server.database.shared.GetAppointmentDataDBAccessImpl;
import shared.Appointment;
import shared.Doctor;

import java.util.ArrayList;

public class GetAppointmentDataServerModelImpl implements GetAppointmentDataServerModel
{
    private GetAppointmentDataDBAccess sharedDBAccess;

    public GetAppointmentDataServerModelImpl()
    {
        sharedDBAccess = new GetAppointmentDataDBAccessImpl();
    }

    @Override
    public ArrayList<Appointment> getAllAppointments()
    {
        return sharedDBAccess.getAllAppointments();
    }

    @Override
    public ArrayList<Appointment> getAppointmentsForDoctor(Doctor doctor)
    {
        return sharedDBAccess.getAppointmentsForDoctor(doctor);
    }
}
