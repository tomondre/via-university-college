package client.model.nurse;

import shared.Appointment;

public interface AppointmentsModelNurse
{
  void createAppointment(Appointment appointment);
  void removeAppointment(Appointment appointment);
}
