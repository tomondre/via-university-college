package Ex22_1;

public class LogLine
{
  private String logEntry;
  private String time;
  public LogLine(String logEntry, String time)
  {
  this.logEntry = logEntry;
  this.time = time;
  }

  public String getLogEntry(){
    return logEntry;
  }

  public String toString(){
    return time + " " + logEntry;
  }
}
