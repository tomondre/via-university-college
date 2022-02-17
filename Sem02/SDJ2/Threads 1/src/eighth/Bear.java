package eighth;

public class Bear implements Runnable
{
  public void run()
  {
    while (true)
    {

      System.out.println("zzzz");

      try
      {
        Thread.sleep(10000);
        System.out.println("Rested");
      }

      catch (InterruptedException e)
      {
        System.out.println("Angry");
      }
    }
  }
}
