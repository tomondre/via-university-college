package shared;

import java.io.Serializable;
import java.sql.Date;

public abstract class Person implements Serializable
{
  private String firstName;
  private String middleName;
  private String lastName;
  private long ssn;
  private Date dob;
  private Address address;
  private String contactFirstName;
  private String contactMiddleName;
  private String contactLastName;
  private String contactPhoneNumber;

  public Person(String firstName, String middleName, String lastName, long ssn,
      Date dob, Address address, String contactFirstName,
      String contactMiddleName, String contactLastName,
      String contactPhoneNumber)
  {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.ssn = ssn;
    this.dob = dob;
    this.address = address;
    this.contactFirstName = contactFirstName;
    this.contactMiddleName = contactMiddleName;
    this.contactLastName = contactLastName;
    this.contactPhoneNumber = contactPhoneNumber;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getMiddleName()
  {
    return middleName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public long getSsn()
  {
    return ssn;
  }

  public Date getDob()
  {
    return dob;
  }

  public Address getAddress()
  {
    return address;
  }

  public String getContactFirstName()
  {
    return contactFirstName;
  }

  public String getContactMiddleName()
  {
    return contactMiddleName;
  }

  public String getContactLastName()
  {
    return contactLastName;
  }

  public String getContactPhoneNumber()
  {
    return contactPhoneNumber;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public void setAddress(Address address)
  {
    this.address = address;
  }

  public void setContactFirstName(String contactFirstName)
  {
    this.contactFirstName = contactFirstName;
  }

  public void setContactMiddleName(String contactMiddleName)
  {
    this.contactMiddleName = contactMiddleName;
  }

  public void setContactLastName(String contactLastName)
  {
    this.contactLastName = contactLastName;
  }

  public void setContactPhoneNumber(String contactPhoneNumber)
  {
    this.contactPhoneNumber = contactPhoneNumber;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public void setMiddleName(String middleName)
  {
    this.middleName = middleName;
  }

  public void setDob(Date dob)
  {
    this.dob = dob;
  }

  @Override public String toString()
  {
    return "Person{" + "firstName='" + firstName + '\'' + ", middleName='"
        + middleName + '\'' + ", lastName='" + lastName + '\'' + ", ssn=" + ssn
        + ", dob=" + dob + ", address=" + address + ", contactFirstName='"
        + contactFirstName + '\'' + ", contactMiddleName='" + contactMiddleName
        + '\'' + ", contactLastName='" + contactLastName + '\''
        + ", contactPhoneNumber='" + contactPhoneNumber + '\'' + '}';
  }

  public String getFullName()
  {
    return middleName == null ?
        firstName + " " + lastName :
        firstName + " " + middleName + " " + lastName;
  }
}
