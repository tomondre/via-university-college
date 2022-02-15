package Cd;

public class Time
{
  int hour, minute, second;
  public Time(int hour, int minute, int second)
  {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public Time(int TotalTimeInSeconds)
  {
    hour = TotalTimeInSeconds / 3600;
    minute = (TotalTimeInSeconds % 3600) / 60;
    second = TotalTimeInSeconds % 60;
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
public int getTimeInSeconds()
{
  return (hour*3600)+(minute*60)+second;
}
  @Override public String toString()
  {
    return "Time{" + "hour=" + hour + ", minute=" + minute + ", second="
        + second + '}';
  }

  public static void main(String[] args)
  {
    Time time = new Time(3599);
    System.out.println(time);
  }
}
