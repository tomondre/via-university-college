package model;

import java.io.Serializable;

/**
 * A class of MyDate object storing the date
 */
public class MyDate implements Serializable
{
  private int day, month, year;

  /**
   * A constructor for creating MyDate object.
   * @param day the day of the MyDate object
   * @param month the month of the MyDate object
   * @param year the year of the MyDate object
   */
  public MyDate(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  /**
   *  Gets a boolean representation of the result after comparing fields from object to the MyDate.
   * @param obj the Object containing fields to compare
   * @return the boolean containing result of the fields comparison.
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof MyDate))
      return false;
    MyDate other = (MyDate)obj;
    return this.day == other.day
        && this.month == other.month
        && this.year == other.year;
  }

  /**
   * Gets a String representation of the MyDate object.
   * @return the String containing information about MyDate object
   */
  public String toString()
  {
    return day + "/" + month + "/" + year;
  }
}
