package ServiceBook;

public class Date
{
  private int year, month, day;

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
    return new Date(day, month, year);
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Date))
    {
      return false;
    }
    Date other = (Date) obj;
    return day == day && month == month && year == year;
  }

  @Override public String toString()
  {
    return "Date{" + "year=" + year + ", month=" + month + ", day=" + day + '}';
  }
}
