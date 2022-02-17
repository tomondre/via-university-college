package server.model.nurse;

import shared.Appointment;
import shared.Patient;

public interface AppointmentsServerModelNurse
{
    void createAppointment(Appointment appointment);
    void removeAppointment(Appointment appointment);
}
