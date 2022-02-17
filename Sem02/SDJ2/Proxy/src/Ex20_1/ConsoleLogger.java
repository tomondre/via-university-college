package Ex20_1;

public class ConsoleLogger implements Logger
{
  @Override public void log(String txt)
  {
    System.out.println(txt);
  }
}
