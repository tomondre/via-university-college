public class Clock
{
  private int hour, minute, second, days;
  private Clock clock;
  private boolean timeFormat24 = true;


  public Clock(int hour, int minute, int second)
  {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public Clock(int TotalTimeInSeconds)
  {
    second = TotalTimeInSeconds;

    hour = TotalTimeInSeconds / 3600;
    minute = (TotalTimeInSeconds % 3600) / 60;
    second = TotalTimeInSeconds % 60;
    /*
    while (second > 59)
    {
      second = second - 60;
      minute++;
    }
    while (minute > 59)
    {
      minute = minute - 60;
      hour++;
    }
    */

  }

  public void set(int hour, int minute, int second)
  {
    this.hour = hour;
    this.minute = minute;
    this.hour = hour;
  }
  public void setTimeFormat(int hourFormat)
  {
    if (hourFormat == 24){
      timeFormat24 = true;
    }
    if (hourFormat == 12){
timeFormat24 = false;
    }
  }
  public boolean isTimeFormat24()
{
  return timeFormat24;
}
  public int getHour()
  {
    return hour;
  }
  public int getMinute()
  {
    return minute;
  }
  public int getSecond()
  {
    return second;
  }
  public void tic()
  {
    second++;
    if (second > 59)
    {
      second = second - 60;
      minute++;
    }
    if (minute > 59)
    {
      minute = minute - 60;
      hour++;
    }

  }

  public int convertToSeconds()
  {
    return (hour * 3600) + (minute * 60) + second;
  }

  public boolean isBefore(Clock clock)
  {
    /*
    if (hour <= clock.hour)
    {
      if (minute <= clock.minute)
      {
        if (second < clock.second)
        {
        return true;
        }
        else if (second == this.second)
        {
          return false;
        }
        else return false;
      }
      else return false;
    }
    else
      return false;
    */
    if (clock.convertToSeconds()<convertToSeconds())
    {
      return false;
    }
    else
    {
      return true;
    }
  }
  public int timeInSecondsTo(Clock clock)
  {
return convertToSeconds() - clock.convertToSeconds();
  }
  public Clock timeTo(Clock clock)
  {
      return new Clock(Math.abs(convertToSeconds() - clock.convertToSeconds()));
  }
  @Override public String toString()
  {
    if(timeFormat24 == true)
    {
    return hour + ":" + minute + ":" + second;
  }
  else {
    days = getSecond() / 86400;
      if (hour>12)
      {
        return (hour-12) + ":" + minute + ":" + second + " PM";
      }
      else return hour + ":" + minute + ":" + second + " AM";
    }
  }
}