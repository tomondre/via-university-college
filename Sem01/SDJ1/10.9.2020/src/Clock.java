public class Clock
{
  private int hour, minute, second,t,totalSeconds;


  public void set(int totalSeconds)
  {
    second = totalSeconds;

  }

  public Clock (int hour, int minute, int second)
  {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }
  public Clock(int s){
    second = s % 60;
    minute = second % 3600;

  }
  public Clock (int s){
    second = s;
    while (second>59)
    {
      second = second - 60;
      minute++;
    }
    while (minute>59)
    {
      minute = minute - 60;
      hour++;
    }
  }

  public int getSecond()
  {
    return second;
  }

  public int getMinute()
  {
    return minute;
  }

  public int getHour()
  {
    return hour;
  }

  public void tic(){
    second++;
}
public boolean isBefore(Clock time)
{
  if (time.getHour()<getHour())
  {
    return true;
  }
  else
    {
      return false;
    }
}
  public void getSeconds()
  {
    totalSeconds = second+(getMinute()*60)+(getHour()*3600);
  }
public int getSeconds(Clock time)
{
  return time.second+(time.getMinute()*60)+(time.getHour()*3600);
}
/*public String timeTo(Clock time)
{
  return (getSeconds(time)-totalSeconds);
}*/



/*public String timeTo(Clock time)
{
return "Rozdiel je:" + (time.getHour() - getHour()) + "hodín" + (time.getMinute()-getMinute()) + "minút" + (time.getSecond()- getSecond())+ "sekúnd";

}*/












  @Override public String toString()
  {
    return "Clock{" + "hour=" + hour + ", minute=" + minute + ", second="
        + second + ", t=" + t + '}';
  }
}
