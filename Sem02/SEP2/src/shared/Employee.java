package shared;

import java.io.Serializable;
import java.sql.Date;

public abstract class Employee extends Person implements Serializable
{
  private Date startDate;
  private String education;
  private String email;
  private String password;

  public Employee(String firstName, String middleName, String lastName,
      long ssn, Date dob, Address address, String contactFirstName,
      String contactMiddleName, String contactLastName,
      String contactPhoneNumber, Date startDate, String education, String email,
      String password)
  {
    super(firstName, middleName, lastName, ssn, dob, address, contactFirstName,
        contactMiddleName, contactLastName, contactPhoneNumber);
    this.startDate = startDate;
    this.education = education;
    this.email = email;
    this.password = password;
  }

  public String getEmail()
  {
    return email;
  }

  public String getPassword()
  {
    return password;
  }

  public void setStartDate(Date startDate)
  {
    this.startDate = startDate;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public Date getStartDate()
  {
    return startDate;
  }

  public String getEducation()
  {
    return education;
  }

  public void setEducation(String education)
  {
    this.education = education;
  }

  @Override public String toString()
  {
    return super.toString() + "startDate=" + startDate + ", education='"
        + education + '\'';
  }
}
