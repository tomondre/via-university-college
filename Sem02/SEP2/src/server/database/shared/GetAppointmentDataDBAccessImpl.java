package server.database.shared;

import server.database.DatabaseAccess;
import shared.Appointment;
import shared.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetAppointmentDataDBAccessImpl implements GetAppointmentDataDBAccess
{
    @Override
    public ArrayList<Appointment> getAllAppointments()
    {
        try (Connection connection = DatabaseAccess.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT * FROM appointed"))
        {
            ResultSet r = preparedStatement.executeQuery();

            ArrayList<Appointment> result = new ArrayList<>();
            while(r.next())
            {
                result.add(new Appointment(r.getTimestamp("time_from"),
                    r.getTimestamp("time_to"),
                    r.getLong("doctor_ssn"),
                    r.getLong("patient_ssn")));
            }
            return result;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Appointment> getAppointmentsForDoctor(Doctor doctor)
    {
        try (Connection connection = DatabaseAccess.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT * FROM appointed WHERE doctor_ssn = ? AND time_to > current_date;"))
        {
            preparedStatement.setLong(1, doctor.getSsn());
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Appointment> result = new ArrayList<>();
            while (resultSet.next())
            {
                result.add(new Appointment(resultSet.getTimestamp("time_from"),
                    resultSet.getTimestamp("time_to"),
                    resultSet.getLong("doctor_ssn"),
                    resultSet.getLong("patient_ssn")));
            }
            return result;
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return null;
    }

}
