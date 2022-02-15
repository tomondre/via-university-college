package Employee;

import java.util.ArrayList;

public class Company
{
  private String name;
  private ArrayList<Employee> employees;

  public Company(String name)
  {
    this.name = name;

  }

  public ArrayList<Employee> getAllEmployees()
  {
    return employees;
  }

  public void hireEmployee(Employee employee)
  {
    employees.add(employee);
  }

  public double getTotalSalary()
  {
    double temp = 0;

    for (int i = 0; i < employees.size(); i++)
    {
      temp += employees.get(i).getSalary();
    }
    return temp;
  }

  public void changeSalary(String employeeName, double newSalary)
  {
    for (int i = 0; i < employees.size(); i++)
    {
      if (employees.get(i).getName().equals(employeeName))
      {
        employees.get(i).setSalary(newSalary);
        break;
      }

    }
  }

  public void fireEmployee(Employee employee)
  {
    employees.remove(employee);

  }

}

