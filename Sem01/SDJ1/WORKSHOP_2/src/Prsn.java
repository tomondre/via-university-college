import java.util.Objects;

public class Prsn
{
  private String firstName, lastName;
  private char gender;
private Job job;
  public Prsn(String firstName, String lastName, char gender, Job job)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.job = job;
  }
  public Prsn(String firstName, String lastName, char gender)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
  }
  public void setFNname(String firstName)
  {
    this.firstName = firstName;
  }
  public void setLName(String lastName )
  {
    this.lastName = lastName;
  }
  public void setGender(char gender)
  {
    this.gender = gender;
  }

  @Override public String toString()
  {
    return "Prsn{" + "firstName='" + firstName + '\'' + ", lastName='"
        + lastName + '\'' + ", gender=" + gender + ", job=" + job + '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Prsn prsn = (Prsn) o;
    return gender == prsn.gender && Objects.equals(firstName, prsn.firstName)
        && Objects.equals(lastName, prsn.lastName) && Objects
        .equals(job, prsn.job);
  }

}
