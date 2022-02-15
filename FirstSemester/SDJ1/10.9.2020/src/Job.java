public class  Job
{
  private int percentage;
  private String title;
  private double salary;
  private Person employee;

  public Job(String title, double salary, Person employee)
  {
    this.title = title;
    this.salary = salary;
    this.employee = employee;
  }
  public Job(String title, double salary)
  {
    this.title = title;
    this.salary = salary;
    employee = null;
  }
  public void setEmployee(Person employee)
  {
    this.employee = employee;
  }

  public void setSalary(double salary)
  {
    this.salary = salary;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getTitle()
  {
    return title;
  }

  public double getSalary()
  {
    return salary;
  }


  public void givePercentageRaise(int percentage){
    this.percentage = percentage;
    salary += salary*(0.01 * percentage);
  }

  @Override public String toString()
  {
    return "title='" + title + '\'' + ", salary=" + salary + ", "
         + employee + '}';
  }

  public Person getEmployee()
  {
    return employee;
  }
}
