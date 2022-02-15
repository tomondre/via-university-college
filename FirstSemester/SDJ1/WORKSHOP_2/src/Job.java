import java.util.Objects;

public class Job
{
  private String positionName,companyName;
  private double salary;

  public Job(String positionName, String companyName, double salary)
  {
    this.positionName = positionName;
    this.companyName = companyName;
    this.salary = salary;
  }
  public String getPosition()
  {
    return positionName;
  }
  public String getCompany()
  {
    return companyName;
  }
  public double getSalary()
  {
    return salary;
  }
  public void setPosition(String positionName)
  {
    this.positionName = positionName;
  }

  public void setCompany(String companyName)
  {
    this.companyName = companyName;
  }

  public void setSalary(double salary)
  {
    this.salary = salary;
  }
  @Override public String toString()
  {
    return "Job{" + "positionName='" + positionName + '\'' + ", companyName='"
        + companyName + '\'' + ", salary=" + salary + '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Job job = (Job) o;
    return Double.compare(job.salary, salary) == 0 && Objects
        .equals(positionName, job.positionName) && Objects
        .equals(companyName, job.companyName);
  }
}

