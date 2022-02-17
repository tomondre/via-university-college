package Ex22_1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Log
{
  private Queue<LogLine> logQueue;
  private File logFile;
  private DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
  private static Log log = new Log();

  private Log()
  {
    logQueue = new LinkedList<>();
    Date date = Calendar.getInstance().getTime();
    String fileName = new SimpleDateFormat("yyyy-mm-dd").format(date);
    logFile = new File(fileName);
  }

  public synchronized void add(String log)
  {
    if (logFile == null || "".equals(log))
    {
      return;
    }
    logQueue.add(
        new LogLine(log, dateFormat.format(Calendar.getInstance().getTime())));
    addToFile(log);
    System.out.println(log);
  }

  private void addToFile(String log)
  {
    if (log == null)
    {
      return;
    }
    BufferedWriter out = null;
    try
    {
      out = new BufferedWriter(new FileWriter(logFile, true));
      out.write(log + "\n");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        out.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }

  private static Log getInstance(){
    return log;
  }
}
