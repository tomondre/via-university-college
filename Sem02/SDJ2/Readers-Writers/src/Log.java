import java.util.ArrayList;

public class Log
{
 private ArrayList<String> logs;
 private Log instance = new Log();


 private Log()
 {
   logs = new ArrayList<>();
 }

 public Log getInstance()
 {
   return instance;
 }

 public void log(String log)
 {
   System.out.println(log);
   logs.add(log);
 }

 public ArrayList<String> getLogs()
 {
   return logs;
 }

}
