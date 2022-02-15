public class Name
{
  private String firstName, lastName;
  public Name(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
  }
  public void setFirstName(String firstName){
    this.firstName = firstName;
  }
  public void setLastName(String lastName)
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
public String getFullName(){
    return firstName + " " + lastName;
}
public Name copy(){
    return new Name(firstName,lastName);
}
public boolean equals(Object obj)
{
  if (!(obj instanceof Name))
  {
    return false;
  }
  Name other = (Name)obj;
  return firstName==other.firstName&&lastName==other.lastName;
}

  @Override public String toString()
  {
    return "Name{" + "firstName='" + firstName + '\'' + ", lastName='"
        + lastName + '\'' + '}';
  }
}
