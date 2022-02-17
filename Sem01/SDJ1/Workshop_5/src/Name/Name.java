package Name;

public class Name
{
  private String lastName, firstName;

  public Name(String firstName)
  {
    this.firstName = firstName;
    lastName = "";
  }

  public Name(String firstName, String lastName)
  {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getFullName()
  {
    return firstName + " " + lastName;
  }

  @Override public String toString()
  {
    return "Name{" + "lastName='" + lastName + '\'' + ", firstName='"
        + firstName + '\'' + '}';
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Name))
    {
      return false;
    }
    Name other = (Name) obj;
    return firstName.equals(other.firstName) && lastName.equals(other.lastName);

  }



  public static void main(String[] args)
  {
    Name name = new Name("Tomas");
    System.out.println(name.getFullName());
  }
}