package server.database.manager;

import server.database.DatabaseAccess;
import shared.Doctor;
import shared.Nurse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDBAccessImpl implements EmployeeDBAccessManager
{
  @Override public String addDoctor(Doctor doctor)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO doctor(ssn, f_name, mid_name, l_name, add_street, add_no, add_zip_code, add_city, dob, start_date, education, specialization, ward_name, room_number, email, password, contact_f_name, contact_mid_name, contact_l_name, contact_phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"))
    {
      prepareDoctorStatement(preparedStatement, doctor);

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public String addNurse(Nurse nurse)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO nurse(ssn, f_name, mid_name, l_name, add_street, add_no, add_zip_code, add_city, dob, start_date, education, experience, email, password, contact_f_name, contact_mid_name, contact_l_name, contact_phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"))
    {
      prepareNurseStatement(preparedStatement, nurse);

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  private void prepareNurseStatement(PreparedStatement preparedStatement,
      Nurse nurse) throws SQLException
  {
    preparedStatement.setLong(1, nurse.getSsn());
    preparedStatement.setString(2, nurse.getFirstName());
    preparedStatement.setString(3, nurse.getMiddleName());
    preparedStatement.setString(4, nurse.getLastName());
    preparedStatement.setString(5, nurse.getAddress().getStreet());
    preparedStatement.setString(6, nurse.getAddress().getNumber());
    preparedStatement.setString(7, nurse.getAddress().getZipcode());
    preparedStatement.setString(8, nurse.getAddress().getCity());
    preparedStatement.setDate(9, nurse.getDob());
    preparedStatement.setDate(10, nurse.getStartDate());
    preparedStatement.setString(11, nurse.getEducation());
    preparedStatement.setString(12, nurse.getExperience());
    preparedStatement.setString(13, nurse.getEmail());
    preparedStatement.setString(14, nurse.getPassword());
    preparedStatement.setString(15, nurse.getContactFirstName());
    preparedStatement.setString(16, nurse.getContactMiddleName());
    preparedStatement.setString(17, nurse.getContactLastName());
    preparedStatement.setString(18, nurse.getContactPhoneNumber());
  }

  @Override public String editDoctor(Doctor doctor)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "UPDATE doctor SET ssn = ?, f_name = ?, mid_name = ?, l_name = ?, add_street = ?, add_no = ?, add_zip_code = ?, add_city = ?, dob = ?, start_date = ?, education = ?, specialization = ?, ward_name = ?, room_number = ?, email = ?, password = ?, contact_f_name = ?, contact_mid_name = ?, contact_l_name = ?, contact_phone = ? WHERE ssn = ?"))
    {
      prepareDoctorStatement(preparedStatement, doctor);
      preparedStatement.setLong(21, doctor.getSsn());

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public String editNurse(Nurse nurse)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "UPDATE nurse SET ssn = ?, f_name = ?, mid_name = ?, l_name = ?, add_street = ?, add_no = ?, add_zip_code = ?, add_city = ?, dob = ?, start_date = ?, education = ?, experience = ?, email = ?, password = ?, contact_f_name = ?, contact_mid_name = ?, contact_l_name = ?, contact_phone = ? WHERE ssn = ?"))
    {
      prepareNurseStatement(preparedStatement, nurse);
      preparedStatement.setLong(19, nurse.getSsn());

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public String removeDoctor(Doctor doctor)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("DELETE FROM doctor WHERE ssn = ?"))
    {
      preparedStatement.setLong(1, doctor.getSsn());

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public String removeNurse(Nurse nurse)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("DELETE FROM nurse WHERE ssn = ?"))
    {
      preparedStatement.setLong(1, nurse.getSsn());

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  private void prepareDoctorStatement(PreparedStatement preparedStatement,
      Doctor doctor) throws SQLException
  {
    preparedStatement.setLong(1, doctor.getSsn());
    preparedStatement.setString(2, doctor.getFirstName());
    preparedStatement.setString(3, doctor.getMiddleName());
    preparedStatement.setString(4, doctor.getLastName());
    preparedStatement.setString(5, doctor.getAddress().getStreet());
    preparedStatement.setString(6, doctor.getAddress().getNumber());
    preparedStatement.setString(7, doctor.getAddress().getZipcode());
    preparedStatement.setString(8, doctor.getAddress().getCity());
    preparedStatement.setDate(9, doctor.getDob());
    preparedStatement.setDate(10, doctor.getStartDate());
    preparedStatement.setString(11, doctor.getEducation());
    preparedStatement.setString(12, doctor.getSpecialization());
    preparedStatement.setString(13, doctor.getWard().getWardName());
    preparedStatement.setInt(14, doctor.getWard().getRoomNumber());
    preparedStatement.setString(15, doctor.getEmail());
    preparedStatement.setString(16, doctor.getPassword());
    preparedStatement.setString(17, doctor.getContactFirstName());
    preparedStatement.setString(18, doctor.getContactMiddleName());
    preparedStatement.setString(19, doctor.getContactLastName());
    preparedStatement.setString(20, doctor.getContactPhoneNumber());
  }
}
