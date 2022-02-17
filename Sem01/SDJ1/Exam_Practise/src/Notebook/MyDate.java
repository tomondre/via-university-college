package Notebook;

public class MyDate
{
  private int day, month, year;

  public MyDate(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
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

  public MyDate copy()
  {
    return new MyDate(day, month, year);
  }

  public String toString()
  {
    return "Day: " + day + " Month: " + month + " Year: " + year;
  }

}
