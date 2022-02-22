package Employee;

public class HourlyEmployee extends Employee
{
  private double wagePerHour, hoursPerWeek;

  public HourlyEmployee(String name, Date birthday, double wagePerHour,
      double hoursWorkedPerWeek)
  {
    super(name, birthday);
    this.wagePerHour = wagePerHour;
    this.hoursPerWeek = hoursWorkedPerWeek;
  }

  public void setWagePewHour(double wagePerHour)
  {
    this.wagePerHour = wagePerHour;
  }

  public double getWagePerHour()
  {
    return wagePerHour;
  }

  public void setHoursWorkedPewWeek(double hoursWorkedPerWeek)
  {
    this.hoursPerWeek = hoursWorkedPerWeek;
  }

  public double getHoursWorkedPerWeek()
  {
    return hoursPerWeek;
  }

  public double earningsPerWeek()
  {
    return wagePerHour * hoursPerWeek;
  }

  public String toString()
  {
    return super.toString() + " WagePerHour: " + wagePerHour
        + " HoursWorkerPerWeek: " + hoursPerWeek;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof HourlyEmployee))
    {
      return false;
    }
    HourlyEmployee other = (HourlyEmployee) obj;
    return super.equals(other) && wagePerHour == other.wagePerHour
        && hoursPerWeek == other.hoursPerWeek;
  }

}
