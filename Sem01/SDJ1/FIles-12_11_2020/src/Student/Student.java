package Student;

import java.io.Serializable;

public class Student implements Serializable
{
  private String firstName, lastName, country;

  public Student(String firstName, String lastName, String country)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.country = country;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getCountry()
  {
    return country;
  }

  public void setCountry(String country)
  {
    this.country = country;
  }

  public String toString()
  {
    return "FirstName: " + firstName + ", LastName: " + lastName + ", country: "
        + country;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Student))
    {
      return false;
    }
    Student other = (Student) obj;
    return firstName.equals(other.firstName) && lastName.equals(other.lastName)
        && country.equals(other.country);
  }

}
