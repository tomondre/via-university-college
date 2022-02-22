package Car;

public class Service
{
  private int mileage;
  private Date date;

  public Service(int mileage, Date date)
  {
    this.date = date.copy();
    this.mileage = mileage;
  }

  public int getMileage()
  {
    return mileage;
  }

  public Date getDate()
  {
    return date.copy();
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Service))
    {
      return false;
    }
    Service other = (Service) obj;
    return mileage == other.mileage && date.equals(other.date);

  }

  @Override public String toString()
  {
    return "Service{" + "mileage=" + mileage + ", date=" + date + '}';
  }
}
