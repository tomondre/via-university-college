package shared;

import java.io.Serializable;
import java.sql.Date;

public class Nurse extends Employee implements Serializable
{
  private String experience;
  private long doctor_ssn;

  public Nurse()
  {
    super(null, null, null, 0L, null, null, null,
          null, null, null, null, null, null, null);
  }

  public Nurse(long ssn, long doctor_ssn, String firstName, String middleName,
      String lastName, Date dob, Address address, String contactFirstName,
      String contactMiddleName, String contactLastName,
      String contactPhoneNumber, Date startDate, String education,
      String experience, String email, String password)
  {
    super(firstName, middleName, lastName, ssn, dob, address, contactFirstName,
        contactMiddleName, contactLastName, contactPhoneNumber, startDate,
        education, email, password);
    this.experience = experience;
    this.doctor_ssn = doctor_ssn;
  }

  public String getExperience()
  {
    return experience;
  }

  public void setExperience(String experience)
  {
    this.experience = experience;
  }

  public long getDoctor_ssn()
  {
    return doctor_ssn;
  }

  public void setDoctor_ssn(long doctor_ssn)
  {
    this.doctor_ssn = doctor_ssn;
  }

  @Override public String toString()
  {
    return super.toString() + "experience='" + experience + "doctor_snn= "
        + doctor_ssn + '\'';
  }
}
