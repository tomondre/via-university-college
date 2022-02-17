package client.model.shared;

import shared.Appointment;
import shared.Doctor;
import shared.util.PropertyChangeSubject;

import java.util.ArrayList;

public interface GetAppointmentDataModel
{
    ArrayList<Appointment> getAllAppointments();
    ArrayList<Appointment> getAppointmentsForDoctor(Doctor doctor);
}
