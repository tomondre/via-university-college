package Employee;

public class PartTimeWorker extends Employee
{
  private int weeklyHours;

  public PartTimeWorker(String name, double salary, int weeklyHours)
  {
    super(name, salary);
    this.weeklyHours = weeklyHours;
  }

  public int getWeeklyHours()
  {
    return weeklyHours;
  }

  public String toString()
  {
    return super.toString() + ", Weeklyhours: " + weeklyHours;
  }
}
