package Employee;

public class FullTimeWorker extends Employee
{

  private String department;
  private String position;

  public FullTimeWorker(String name, double salary, String department,
      String position)
  {
    super(name, salary);
    this.department = department;
    this.position = position;
  }

  public String getDepartment()
  {
    return department;
  }

  public String getPostion()
  {
    return position;
  }

  public String toString()
  {
    return super.toString() + ", Department: " + department + ", Position: "
        + position;
  }
}

