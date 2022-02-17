package fifth;

public class Run implements Runnable
{

  private int x;
  private int y;
  private Thread threadToJoin;

  public Run(int x, int y, Thread t)
  {
    this.x = x;
    this.y = y;
    threadToJoin = t;
  }

  @Override public void run()
  {
    if (threadToJoin != null)
    {
      try
      {
        threadToJoin.join();
      }
      catch (InterruptedException e)
      {

      }
    }

    for (int i = 0; i < y - x; i++)
    {
      System.out.println(x + i);
    }
  }
}
