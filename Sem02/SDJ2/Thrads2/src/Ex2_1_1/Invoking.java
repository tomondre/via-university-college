package Ex2_1_1;

public class Invoking implements Runnable
{
  private Counter counter;

  public Invoking(Counter counter)
  {
    this.counter = counter;
  }

  @Override public void run()
  {
    for (int i = 0; i < 1000000; i++)
    {
      counter.count();
    }
    System.out.println(counter.getCount());
  }
}
