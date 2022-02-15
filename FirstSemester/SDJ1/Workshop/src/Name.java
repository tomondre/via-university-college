public class Name
{
  String firstName, lastName;
    public Name (String firstName, String lastName)
    {
      this.firstName = firstName;
      this.lastName = lastName;
    }
public void setFirstName()
{
  this.firstName = firstName;
}
  public void setLastName()
  {
    this.lastName = lastName;
  }
  public String getFirstName()
  {
    return firstName;
  }
  public String getLastName()
  {
    return lastName;
  }
  public String getFullName()
  {
    return getFirstName() + " "+ getLastName();
      }

  @Override public String toString()
  {
    return "Name{" + "firstName='" + firstName + '\'' + ", lastName='"
        + lastName + '\'' + '}';
  }
}
