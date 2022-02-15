package server.database.shared;

import server.database.DatabaseAccess;
import shared.Address;
import shared.Doctor;
import shared.Nurse;
import shared.Ward;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetEmployeeDataDBAccessImpl implements GetEmployeeDataDBAccess
{
  @Override public ArrayList<Doctor> getListOfAllDoctors()
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("SELECT * FROM doctor"))
    {
      ResultSet r = preparedStatement.executeQuery();

      ArrayList<Doctor> result = new ArrayList<>();

      while (r.next())
      {
        Address address = new Address(r.getString("add_street"),
            r.getString("add_no"), r.getString("add_zip_code"),
            r.getString("add_city"));

        result.add(new Doctor(r.getString("f_name"), r.getString("mid_name"),
            r.getString("l_name"), r.getLong("ssn"), r.getDate("dob"), address,
            r.getString("contact_f_name"), r.getString("contact_mid_name"),
            r.getString("contact_l_name"), r.getString("contact_phone"),
            r.getDate("start_date"), r.getString("education"),
            r.getString("specialization"),
            new Ward(r.getString("ward_name"), r.getInt("room_number")),
            r.getString("email"), r.getString("password")));
      }
      return result;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public ArrayList<Nurse> getListOfAllNurses()
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("SELECT * FROM nurse"))
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

  @Override public Doctor getDoctorBySSN(long ssn)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("SELECT * FROM doctor WHERE ssn = ?"))
    {
      preparedStatement.setLong(1, ssn);

      ResultSet r = preparedStatement.executeQuery();
      if (r.next())
      {
        Address address = new Address(r.getString("add_street"),
            r.getString("add_no"), r.getString("add_zip_code"),
            r.getString("add_city"));

        return new Doctor(r.getString("f_name"), r.getString("mid_name"),
            r.getString("l_name"), r.getLong("ssn"), r.getDate("dob"), address,
            r.getString("contact_f_name"), r.getString("contact_mid_name"),
            r.getString("contact_l_name"), r.getString("contact_phone"),
            r.getDate("start_date"), r.getString("education"),
            r.getString("specialization"),
            new Ward(r.getString("ward_name"), r.getInt("room_number")),
            r.getString("email"), r.getString("password"));
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public Nurse getNurseBySSN(long ssn)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("SELECT * FROM nurse WHERE ssn = ?"))
    {
      preparedStatement.setLong(1, ssn);

      ResultSet r = preparedStatement.executeQuery();
      if (r.next())
      {
        Address address = new Address(r.getString("add_street"),
            r.getString("add_no"), r.getString("add_zip_code"),
            r.getString("add_city"));

        return new Nurse(r.getLong("ssn"), r.getLong("doctor_ssn"),
            r.getString("f_name"), r.getString("mid_name"),
            r.getString("l_name"), r.getDate("dob"), address,
            r.getString("contact_f_name"), r.getString("contact_mid_name"),
            r.getString("contact_l_name"), r.getString("contact_phone"),
            r.getDate("start_date"), r.getString("education"),
            r.getString("experience"), r.getString("email"),
            r.getString("password"));
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

}
