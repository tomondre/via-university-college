import java.util.GregorianCalendar;
public class MyDate
{
  private int day, month, year, dif;
  private boolean isLeapYear = false;
  private MyDate mydate;
  public MyDate(int day, int month, int year){
    if (year < 1)
    {
      year = year * -1;
    }
    if (month < 1)
    {
      month = 1;
    }
    if (month > 12)
    {
      month = 12;
    }
    if (day > numberOfDaysInMonth())
    {
      if (month == 2)
      {
        day = 28;
      }
      else if (month == 4 || month == 6 || month == 9 || month == 11)
      {
        day = 30;
      }
      else
      {
        day = 31;
      }
    }
    this.day = day;
    this.month = month;
    this.year = year;
  }
  public MyDate(MyDate m){
    day = m.day;
    month = m.month;
    year = m.year;
  }
  public MyDate(){
    GregorianCalendar currentDate = new GregorianCalendar();
    day = currentDate.get(GregorianCalendar.DATE);
    month = currentDate.get(GregorianCalendar.MONTH)+1;
    year = currentDate.get(GregorianCalendar.YEAR);
  }
  public int getYear()
  {
    return year;
  }
  public int getDay()
  {
    return day;
  }
  public int getMonth()
  {
    return month;
  }
  public void setDay(int day)
  {
    this.day = day;
  }
  public void setMonth(int month)
  {
    this.month = month;
  }
  public void setYear(int year)
  {
    this.year = year;
  }
  public boolean isLeapYear(){
    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  public int numberOfDaysInMonth(){
    if (month == 2)
    {
      return 28;
    }
    else if (month == 4 || month == 6 || month == 9 || month == 11)
    {
      return 30;
    }
    else
    {
      return 31;
    }
  }
  public String getMonthName(int k){
    switch (k)
    {
      case 1:
        return "January";
      case 2:
        return "February";
      case 3:
        return "March";
      case 4:
        return "April";
      case 5:
        return "May";
      case 6:
        return "June";
      case 7:
        return "July";
      case 8:
        return "August";
      case 9:
        return "September";
      case 10:
        return "October";
      case 11:
        return "November";
      default:
        return "December";
    }
  }
  public void nextDays(int d){
    for (;d>0;d--)
    {
      day++;
      if (day > numberOfDaysInMonth())
      {
        day = 1;
        setMonth(getMonth() + 1);
      }
      if (month > 12)
      {
        month = 1;
        year++;
      }
    }
  }
  public void stepForwardOneDay(){

    day = day + 1;
    if (day > numberOfDaysInMonth())
    {
      day = 1;
      setMonth(getMonth() + 1);
    }
    if (month > 12)
    {
      month = 1;
      year++;
    }
  }
  public boolean isBefore(int d, int m, int y){
    if (getYear() >= y)
    {
      if (getMonth() >= m)
      {
        if (getDay() >= d)
        {
          return true;
        }
        else
        {
          return false;
        }
      }
      else
      {
        return false;
      }
    }
    else
    {
      return false;
    }
  }
  public boolean isBefore(MyDate o){
    if (getYear() >= o.year)
    {
      if (getMonth() >= o.month)
      {
        if (getDay() >= o.day)
        {
          return true;
        }
        else
        {
          return false;
        }
      }
      else
      {
        return false;
      }
    }
    else
    {
      return false;
    }
  }
  public int yearsBetween(MyDate date) {
    dif = (getYear() - date.getYear()) * (-1);
    if (getMonth() < date.getMonth())
    {
      dif = dif - 1;
    }
    else if (getMonth() == date.getMonth() && getDay() > date.getDay())
    {
      dif = dif - 1;
    }
    return dif;
  }
  public String toString(){
    return "MyDate{" + "day=" + day + ", month=" + month + ", year=" + year;
  }
  public String getAstroSign(){
    if ((month == 3 || day > 21) || (month == 4 || day <= 19))
    {
      return "Aries";
    }
    if ((month == 4 || day >= 20) || (month == 5 || day <= 20))
    {

      return "Taurus";
    }
    if ((month == 5 || day >= 21) || (month == 6 || day <= 22))
    {

      return "Gemini";
    }
    /*if ((month == 6 || day >= 21) || (month == 7 || day <= 22))
    {

     */

    return "Cancer";
  }
  public boolean isEqualTo(MyDate mydate){
    if (toString().equals(mydate.toString()))
    {
      return true;
    }
    else return false;
  }
  public boolean equals(Object obj){
    if (!(obj instanceof MyDate)){return false;}
    MyDate other = (MyDate)obj;
    if (year == other.year && month == other.month && day == other.day)
    {
    return true;
    }
    else return false;
  }
  public MyDate copy(){
    return new MyDate(day,month,year);
  }
  public static MyDate today(){
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentDay = currentDate.get(GregorianCalendar.DATE);
    int currentMonth = currentDate.get(GregorianCalendar.MONTH)+1;
    int currentYear = currentDate.get(GregorianCalendar.YEAR);
    return new MyDate(currentDay,currentMonth,currentYear);
  }
  public static void main(String[] args){
    MyDate m = new MyDate(28,10,2000);
    System.out.println(today());
  }
  }