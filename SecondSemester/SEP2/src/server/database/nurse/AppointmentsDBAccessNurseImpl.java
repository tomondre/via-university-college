package server.database.nurse;

import server.database.DatabaseAccess;
import shared.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppointmentsDBAccessNurseImpl implements AppointmentsDBAccessNurse
{
  @Override public void createAppointment(Appointment appointment)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO appointed(patient_ssn, doctor_ssn, time_from, time_to) VALUES (?, ?, ?, ?)"))
    {
      preparedStatement.setLong(1, appointment.getPatientSSN());
      preparedStatement.setLong(2, appointment.getDoctorSSN());
      preparedStatement.setTimestamp(3, appointment.getFrom());
      preparedStatement.setTimestamp(4, appointment.getTo());

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void removeAppointment(Appointment appointment)
  {

    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "DELETE FROM appointed WHERE patient_ssn = ? AND doctor_ssn = ? AND time_from = ? AND time_to = ?"))
    {
      preparedStatement.setLong(1, appointment.getPatientSSN());
      preparedStatement.setLong(2, appointment.getDoctorSSN());
      preparedStatement.setTimestamp(3, appointment.getFrom());
      preparedStatement.setTimestamp(4, appointment.getTo());

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
