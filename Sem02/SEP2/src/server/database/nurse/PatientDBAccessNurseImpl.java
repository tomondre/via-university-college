package server.database.nurse;

import server.database.DatabaseAccess;
import shared.Address;
import shared.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDBAccessNurseImpl implements PatientDBAccessNurse
{
  @Override public void addPatient(Patient patient)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO patient(ssn, f_name, mid_name, l_name, add_street, add_no, add_zip_code, add_city, dob, gender, blood_type, medical_description, contact_f_name, contact_mid_name, contact_l_name, contact_phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"))
    {

      preparePatientStatement(preparedStatement, patient);

      preparedStatement.execute();
    }
    catch (SQLException sqlException)
    {
      sqlException.printStackTrace();
    }
  }

  @Override public void editPatient(Patient patient)
  {

    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "UPDATE patient SET ssn = ?, f_name = ?, mid_name = ?, l_name = ?, add_street = ?, add_no = ?, add_zip_code = ?, add_city = ?, dob = ?, gender = ?, blood_type = ?, medical_description = ?, contact_f_name = ?, contact_mid_name = ? ,contact_l_name = ?, contact_phone = ? WHERE ssn = ?"))
    {
      preparePatientStatement(preparedStatement, patient);
      preparedStatement.setLong(17, patient.getSsn());

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }

  @Override public void removePatient(Patient patient)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("DELETE FROM patient WHERE ssn = ?"))
    {
      preparedStatement.setLong(1, patient.getSsn());

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  private void preparePatientStatement(PreparedStatement preparedStatement,
      Patient patient) throws SQLException
  {
    preparedStatement.setLong(1, patient.getSsn());
    preparedStatement.setString(2, patient.getFirstName());
    preparedStatement.setString(3, patient.getMiddleName());
    preparedStatement.setString(4, patient.getLastName());
    preparedStatement.setString(5, patient.getAddress().getStreet());
    preparedStatement.setString(6, patient.getAddress().getNumber());
    preparedStatement.setString(7, patient.getAddress().getZipcode());
    preparedStatement.setString(8, patient.getAddress().getCity());
    preparedStatement.setDate(9, patient.getDob());
    preparedStatement.setString(10, String.valueOf(patient.getGender()));
    preparedStatement.setString(11, patient.getBlood_type());
    preparedStatement.setString(12, patient.getMedical_description());
    preparedStatement.setString(13, patient.getContactFirstName());
    preparedStatement.setString(14, patient.getContactMiddleName());
    preparedStatement.setString(15, patient.getContactLastName());
    preparedStatement.setString(16, patient.getContactPhoneNumber());
  }
}
