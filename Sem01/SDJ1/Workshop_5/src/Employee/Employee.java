package Employee;

public class Employee
{
  private String name;
  private double salary;

  public Employee(String name, double salary)
  {
    this.name = name;
    this.salary = salary;
  }

  public String getName()
  {
    return name;
  }

  public double getSalary()
  {
    return salary;
  }

  public void setSalary(double salary)
  {
    this.salary = salary;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Employee) )
    {
      return false;
    }
    Employee other = (Employee) obj;
    return name.equals(other.getName())&&salary == other.salary;
  }
}