package Exercise;

public abstract class Employee
{
  private String email;
  private String name;

  public Employee(String email, String name)
  {
    this.email = email;
    this.name = name;
  }

  public String getEmail()
  {
    return email;
  }

  public String getName()
  {
    return name;
  }

  public String toString()
  {
    return "Name: " + name + ", email: " + email;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Employee))
    {
      return false;
    }

    Employee other = (Employee) obj;

    return email.equals(other.email) && name.equals(other.name);
  }

  public abstract String getRole();
}
