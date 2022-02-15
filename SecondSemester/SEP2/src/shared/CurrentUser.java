package shared;

import server.database.DatabaseAccess;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class responsible for storing the logged in user in the client
 */
public class CurrentUser implements Serializable
{
  private Employee user;
  private static CurrentUser currentUser;
  private int doctorsAppointments;

  private CurrentUser()
  {
  }

  public static CurrentUser getInstance()
  {
    if (currentUser == null)
    {
      currentUser = new CurrentUser();
    }
    return currentUser;
  }

  public Employee getCurrentUser()
  {
    return user;
  }

  /**
   * Sets the user by fetching the the user form the database
   * @param loginUser the logged in username and password
   */
  public void setUser(LoginUser loginUser)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection())
    {
      Statement statement = connection.createStatement();

      String query =
          "SELECT * FROM " + loginUser.getAccessType() + " WHERE email = '"
              + loginUser.getUsername() + "' AND password = '" + loginUser
              .getPassword() + "'";

      ResultSet r = statement.executeQuery(query);
      r.next();

      if (loginUser.getAccessType() == AccessType.DOCTOR)
      {
        Address address = new Address(r.getString("add_street"),
            r.getString("add_no"), r.getString("add_zip_code"),
            r.getString("add_city"));

        user = new Doctor(r.getString("f_name"), r.getString("mid_name"),
            r.getString("l_name"), r.getLong("ssn"), r.getDate("dob"), address,
            r.getString("contact_f_name"), r.getString("contact_mid_name"),
            r.getString("contact_l_name"), r.getString("contact_phone"),
            r.getDate("start_date"), r.getString("education"),
            r.getString("specialization"),
            new Ward(r.getString("ward_name"), r.getInt("room_number")),
            r.getString("email"), r.getString("password"));
            doctorsAppointments = r.getInt("nr_appointments");
      }

      else if (loginUser.getAccessType() == AccessType.NURSE)
      {
        Address address = new Address(r.getString("add_street"),
            r.getString("add_no"), r.getString("add_zip_code"),
            r.getString("add_city"));

        user = new Nurse(r.getLong("ssn"), r.getLong("doctor_ssn"),
            r.getString("f_name"), r.getString("mid_name"),
            r.getString("l_name"), r.getDate("dob"), address,
            r.getString("contact_f_name"), r.getString("contact_mid_name"),
            r.getString("contact_l_name"), r.getString("contact_phone"),
            r.getDate("start_date"), r.getString("education"),
            r.getString("experience"), r.getString("email"),
            r.getString("password"));
      }

      else if (loginUser.getAccessType() == AccessType.MANAGER)
      {
        Address address = new Address(r.getString("add_street"),
            r.getString("add_no"), r.getString("add_zip_code"),
            r.getString("add_city"));

        user = new Manager(r.getLong("ssn"), r.getString("f_name"),
            r.getString("mid_name"), r.getString("l_name"), r.getDate("dob"),
            address, r.getString("contact_f_name"),r.getString("contact_mid_name"), r.getString("contact_l_name"),
            r.getString("contact_phone"), r.getDate("start_date"), r.getString("education"),
            r.getString("position"), r.getString("email"),
            r.getString("password"));
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  public boolean isNurse()
  {
    return user instanceof  Nurse;
  }

  public boolean isDoctor()
  {
    return user instanceof Doctor;
  }

  public boolean isManager()
  {
    return user instanceof Manager;
  }

  public String getFullName()
  {
    return user.getFullName();
  }

  public int getNrOfAppointments()
  {
    return doctorsAppointments;
  }
}
