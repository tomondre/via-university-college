package server.database.doctor;

import server.database.DatabaseAccess;
import shared.Address;
import shared.Doctor;
import shared.Nurse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NursesDBAccessDoctorImpl implements NursesDBAccessDoctor
{
  @Override public ArrayList<Nurse> getAllAvailableNurses()
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("SELECT * FROM nurse WHERE doctor_ssn is null"))
    {
      ResultSet r = preparedStatement.executeQuery();

      ArrayList<Nurse> result = new ArrayList<>();

      while (r.next())
      {
        Address address = new Address(r.getString("add_street"),
            r.getString("add_no"), r.getString("add_zip_code"),
            r.getString("add_city"));

        result.add(new Nurse(r.getLong("ssn"), r.getLong("doctor_ssn"),
            r.getString("f_name"), r.getString("mid_name"),
            r.getString("l_name"), r.getDate("dob"), address,
            r.getString("contact_f_name"), r.getString("contact_mid_name"),
            r.getString("contact_l_name"), r.getString("contact_phone"),
            r.getDate("start_date"), r.getString("education"),
            r.getString("experience"), r.getString("email"),
            r.getString("password")));
      }
      return result;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void assignNurse(Nurse nurse, Doctor doctor)
  {

    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("update nurse set doctor_ssn = ? where ssn = ?"))
    {
      preparedStatement.setLong(1, doctor.getSsn());
      preparedStatement.setLong(2, nurse.getSsn());

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }

  @Override public ArrayList<Nurse> getAllNursesAssignedToMe(Doctor doctor)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("Select * from nurse where doctor_ssn = ?"))
    {
      preparedStatement.setLong(1, doctor.getSsn());
      ResultSet r = preparedStatement.executeQuery();

      ArrayList<Nurse> result = new ArrayList<>();
      while (r.next())
      {
        Address address = new Address(r.getString("add_street"),
            r.getString("add_no"), r.getString("add_zip_code"),
            r.getString("add_city"));

        result.add(new Nurse(r.getLong("ssn"), r.getLong("doctor_ssn"),
            r.getString("f_name"), r.getString("mid_name"),
            r.getString("l_name"), r.getDate("dob"), address,
            r.getString("contact_f_name"), r.getString("contact_mid_name"),
            r.getString("contact_l_name"), r.getString("contact_phone"),
            r.getDate("start_date"), r.getString("education"),
            r.getString("experience"), r.getString("email"),
            r.getString("password")));
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
