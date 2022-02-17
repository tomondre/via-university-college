package third;

public class Number implements Runnable
{

  private int num;

  public Number(int num)
  {
    this.num = num;
  }

  @Override public void run()
  {
    while (true)
    {
      for (int i = 0; i <num; i++)
      {
        System.out.println(i);
        try
        {
          Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {

        }
      }
    }
  }
}
