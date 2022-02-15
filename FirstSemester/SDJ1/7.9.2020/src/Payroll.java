public class Payroll
{
  private double rate, hours;
  private String name;
  public void setRate(double r)
  {
    rate = r;
  }
  public void setHours(double h)
  {
    hours = h;
  }
  public void setName(String n)
  {
    name=n;
  }

  public double getRate()
  {
    return rate;
  }
  public double getHours()
  {
    return hours;
  }
  public String getName()
  {
    return name;
  }
}
