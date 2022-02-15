package Employee;

import java.util.ArrayList;

public class EmployeeList
{
  private int size;
  private ArrayList<Employee> employees;

  public EmployeeList(int maxNumberOfEmployees)
  {
    size = maxNumberOfEmployees;
  }

  public void addEmployee(Employee employee)
  {
    employees.add(employee);
  }

  public void removeEmployee(Employee employee)
  {
    employees.remove(employee);
  }

  public int getNumberOfEmployees()
  {
    return employees.size();
  }

  public Employee[] getAllEmployees()
  {
    return employees.toArray(new Employee[employees.size()]);
  }

  public double getTotalEarningsPerWeek()
  {
    double temp = 0;
    for (int i = 0; i < employees.size(); i++)
    {
      temp += employees.get(i).earningsPerWeek();
    }
    return temp;
  }

  public String toString()
  {
    String temp = "";
    for (Employee employee : employees)
    {
      temp = temp + " " + employees;

    }
    return temp;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof EmployeeList))
    {
      return false;
    }
    EmployeeList other = (EmployeeList) obj;
    return size == other.size && employees.equals(other.employees);
  }

}
