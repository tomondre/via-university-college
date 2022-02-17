package Exercise;

import java.util.ArrayList;

public class EmployeeList
{
  private ArrayList<Employee> employees;

  public EmployeeList()
  {
    this.employees = new ArrayList<Employee>();
  }

  public void addTeamMember(Employee employee)
  {

  }

  public ArrayList<Employee> getEmployees()
  {
    return employees;
  }

  public String toString()
  {
    String result = "";

    for (Employee employee : employees)
    {
      result += employee.toString() + "\n";
    }

    return result;
  }
}
