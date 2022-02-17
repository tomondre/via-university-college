package Ex2_4;

public class CounterDecrement implements Runnable
{

  private int updates;
  private Counter counter;

  public CounterDecrement(Counter counter, int updates)
  {
    this.counter = counter;
    this.updates = updates;
  }

  @Override public void run()
  {

    for (int i = 0; i < updates; i++)

    {
      counter.decrement();
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e) {}
    }
  }
}
