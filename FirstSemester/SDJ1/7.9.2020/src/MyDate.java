public class MyDate
{
  private int day, month, year;

  public MyDate(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public void setDay(int d)
  {
    day = d;
  }

  public void setMonth(int m)
  {
    month = m;
  }

  public void setYear(int y)
  {
    year = y;
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public boolean isLeapYear()
  {
    if (year % 4 == 0 || year % 100 == 0 || year % 400 == 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public void nextDay()
{
    day++;
}
}
