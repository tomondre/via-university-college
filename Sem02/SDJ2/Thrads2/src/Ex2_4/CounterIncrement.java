package Ex2_4;

public class CounterIncrement implements Runnable
{
  private int updates;
  private Counter counter;

  public CounterIncrement(Counter counter, int updates)
  {
    this.counter = counter;
    this.updates = updates;
  }

  @Override public void run()
  {
    for (int i = 0; i <updates; i++)
    {

      counter.increment();
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
      }
    }
  }
}
