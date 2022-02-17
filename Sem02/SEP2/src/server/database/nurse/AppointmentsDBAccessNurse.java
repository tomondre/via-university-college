package server.database.nurse;

import shared.Appointment;
import shared.Patient;

public interface AppointmentsDBAccessNurse
{
    void createAppointment(Appointment appointment);
    void removeAppointment(Appointment appointment);
}
