public class Date
{
  private int day,month,year;

  public Date(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }
  public Date()
  {
    day = 0;
    month = 0;
    year = 0;
  }
  public void set(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }
  public Date copy()
  {
    return new Date(day,month,year);
  }
  @Override public String toString()
  {
    return "Date{" + "day=" + day + ", month=" + month + ", year=" + year + '}';
  }
}
