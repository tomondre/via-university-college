package shared;

import java.sql.Date;

public class Manager extends Employee
{
  private String position;

  public Manager(long ssn, String firstName, String middleName, String lastName,
      Date dob, Address address, String contactFirstName,
      String contactMiddleName, String contactLastName,
      String contactPhoneNumber, Date startDate, String education,
      String position, String email, String password)
  {
    super(firstName, middleName, lastName, ssn, dob, address, contactFirstName,
        contactMiddleName, contactLastName, contactPhoneNumber, startDate,
        education, email, password);
    this.position = position;
  }

  public String getPosition()
  {
    return position;
  }

  public void setPosition(String position)
  {
    this.position = position;
  }

  public String getFullName()
  {
    return super.getFullName();
  }
}
