package Employee;

public abstract class Employee
{
  private String name;
  private Date birthday;

  public Employee(String name, Date birthday)
  {
    this.birthday = birthday.copy();
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Date getBirthday()
  {
    return birthday.copy();
  }

  public String toString()
  {
    return " Date: " + birthday + " Name: " + name;
  }

  public boolean equals(Object obj)
  {

    if (!(obj instanceof Employee))
    {
      return false;
    }
    Employee other = (Employee) obj;
    return birthday.equals(other.birthday) && name.equals(other.name);
  }

  public abstract double earningsPerWeek();

}
