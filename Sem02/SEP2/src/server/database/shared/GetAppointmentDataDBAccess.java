package server.database.shared;

import shared.Appointment;
import shared.Doctor;

import java.util.ArrayList;

public interface GetAppointmentDataDBAccess
{
    ArrayList<Appointment> getAllAppointments();
    ArrayList<Appointment> getAppointmentsForDoctor(Doctor doctor);
}
