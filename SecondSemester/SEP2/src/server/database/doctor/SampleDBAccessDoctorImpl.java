package server.database.doctor;

import server.database.DatabaseAccess;
import shared.Patient;
import shared.Sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SampleDBAccessDoctorImpl implements SampleDBAccessDoctor
{
  @Override public ArrayList<Sample> getAllSamples()
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("Select * from sample"))
    {
      ResultSet r = preparedStatement.executeQuery();

      ArrayList<Sample> result = new ArrayList<>();

      while (r.next())
      {
        result.add(new Sample(r.getString("type"), r.getString("result"),
            r.getInt("priority"), r.getDate("deadline"),
            r.getLong("patient_ssn"), r.getInt("sample_id")));
      }

      return result;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void createSample(Sample sample)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "insert into sample(type, result, deadline, priority, patient_ssn) VALUES (?, ?, ?, ?, ?)"))
    {
      setSampleStatement(preparedStatement, sample);

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void editSample(Sample sample)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "update sample set type = ?, result = ?, deadline = ?, priority = ?, patient_ssn = ?  where sample_id = ?"))
    {
      setSampleStatement(preparedStatement, sample);

      preparedStatement.setInt(6, sample.getSample_id());
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public Sample getSampleById(int id)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("SELECT * FROM sample WHERE sample_id = ?"))
    {
      preparedStatement.setInt(1, id);

      ResultSet r = preparedStatement.executeQuery();

      if (r.next())
      {
        return new Sample(r.getString("type"), r.getString("result"),
            r.getInt("priority"), r.getDate("deadline"),
            r.getLong("patient_ssn"), r.getInt("sample_id"));
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public ArrayList<Sample> getAllPatientSamples(Patient patient)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("SELECT * FROM sample WHERE patient_ssn = ?"))
    {
      preparedStatement.setLong(1, patient.getSsn());

      ResultSet r = preparedStatement.executeQuery();

      ArrayList<Sample> result = new ArrayList<>();
      while (r.next())
      {
        result.add(new Sample(r.getString("type"), r.getString("result"),
            r.getInt("priority"), r.getDate("deadline"),
            r.getLong("patient_ssn"), r.getInt("sample_id")));
      }
      return result;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  private void setSampleStatement(PreparedStatement statement, Sample sample)
      throws SQLException
  {
    statement.setString(1, sample.getType());
    statement.setString(2, sample.getResult());
    statement.setDate(3, sample.getDeadline());
    statement.setInt(4, sample.getPriority());
    statement.setLong(5, sample.getPatient_ssn());
  }
}
