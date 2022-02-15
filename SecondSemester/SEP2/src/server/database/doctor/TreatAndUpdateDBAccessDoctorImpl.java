package server.database.doctor;

import server.database.DatabaseAccess;
import shared.Diagnosis;
import shared.Doctor;
import shared.Patient;
import shared.Treatment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TreatAndUpdateDBAccessDoctorImpl
    implements TreatAndUpdateDBAccessDoctor
{

  @Override public void addDiagnosisToPatient(Patient patient,
      Diagnosis diagnosis)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement1 = connection.prepareStatement(
            "INSERT INTO diagnosis(severity_level, name, description) VALUES (?, ?, ?)");
        PreparedStatement preparedStatement2 = connection.prepareStatement(
            "INSERT INTO suffer_from(patient_ssn, diagnosis_id, severity_level, date_from) VALUES (?, ?, ?, ?)"))
    {
      setStatementDiagnosis(preparedStatement1, diagnosis);
      preparedStatement1.execute();

      PreparedStatement getIdOfDiagnosis = connection.prepareStatement(
          "SELECT id FROM diagnosis WHERE severity_level = ? and name = ? and description = ?");

      setStatementDiagnosis(getIdOfDiagnosis, diagnosis);
      ResultSet resultSet = getIdOfDiagnosis.executeQuery();
      resultSet.next();
      diagnosis.setId(resultSet.getInt("id"));

      preparedStatement2.setLong(1, patient.getSsn());
      preparedStatement2.setInt(2, diagnosis.getId());
      preparedStatement2.setInt(3, diagnosis.getSeverityLevel());
      preparedStatement2.setDate(4, diagnosis.getDateFrom());

      preparedStatement2.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  private void setStatementDiagnosis(PreparedStatement preparedStatement,
      Diagnosis diagnosis) throws SQLException
  {
    preparedStatement.setInt(1, diagnosis.getSeverityLevel());
    preparedStatement.setString(2, diagnosis.getName());
    preparedStatement.setString(3, diagnosis.getDescription());
  }

  @Override public void treatPatient(Patient patient, Diagnosis diagnosis,
      Doctor doctor, Treatment treatment)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO treats(medication, description, doctor_ssn, patient_ssn, diagnosis_id, severity_level) VALUES (?, ?, ?, ?, ?, ?)"))
    {
      preparedStatement.setString(1, treatment.getMedication());
      preparedStatement.setString(2, treatment.getDescription());
      preparedStatement.setLong(3, doctor.getSsn());
      preparedStatement.setLong(4, patient.getSsn());
      preparedStatement.setInt(5, diagnosis.getId());
      preparedStatement.setInt(6, diagnosis.getSeverityLevel());

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public ArrayList<Diagnosis> getAllDiagnosisOfPatient(
      Patient patient)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT diagnosis.id, diagnosis.severity_level, diagnosis.name, diagnosis.description FROM diagnosis JOIN suffer_from sf ON diagnosis.id = sf.diagnosis_id WHERE patient_ssn = ?;"))
    {
      preparedStatement.setLong(1, patient.getSsn());

      ResultSet rs = preparedStatement.executeQuery();

      ArrayList<Diagnosis> result = new ArrayList<>();
      while (rs.next())
      {
        result.add(
            new Diagnosis(rs.getString("name"), rs.getInt("severity_level"),
                rs.getString("description"), null, rs.getInt("id")));
      }
      return result;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void editDiagnosis(Diagnosis diagnosis)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "UPDATE diagnosis SET name = ?, description = ?, severity_level = ? WHERE id = ?"))
    {
      preparedStatement.setString(1, diagnosis.getName());
      preparedStatement.setString(2, diagnosis.getDescription());
      preparedStatement.setInt(3, diagnosis.getSeverityLevel());
      preparedStatement.setInt(4, diagnosis.getId());

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public ArrayList<Treatment> getAllTreatmentsOfPatient(
      Patient patient, Doctor doctor)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT treats.description, medication, name, treats.severity_level from treats join diagnosis d on d.id = treats.diagnosis_id and d.severity_level = treats.severity_level WHERE treats.patient_ssn = ? AND doctor_ssn = ?;"))
    {
      preparedStatement.setLong(1, patient.getSsn());
      preparedStatement.setLong(2, doctor.getSsn());

      ResultSet r = preparedStatement.executeQuery();
      ArrayList<Treatment> result = new ArrayList<>();
      while (r.next())
      {
        Treatment toAdd = new Treatment(r.getString("medication"),
            r.getString("description"));
        toAdd.setDiagnosisName(r.getString("name"));
        toAdd.setSeverityLevel(r.getInt("severity_level"));

        result.add(toAdd);
      }
      return result;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
