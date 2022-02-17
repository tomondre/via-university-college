package Ex2_4;

public class Counter
{
  private long value;
  private long max;
  private long min;

  public Counter(long min, long max)
  {
    this.max = max;
    this.min = min;
  }

  public synchronized void increment()
  {
    if (value >= max)
    {
      try
      {
        Thread.sleep(100);
        increment();
      }
      catch (InterruptedException e)
      {
      }
    }
    value++;
    System.out.println(value + ": " + Thread.currentThread().getName());
  }

  public synchronized void decrement()
  {
    if (value <= min)
    {
      try
      {
        Thread.sleep(100);
        decrement();
      }
      catch (InterruptedException e)
      {
      }
    }
    value--;
    System.out.println(value + ": " + Thread.currentThread().getName());
  }

  public synchronized long getValue()
  {
    return value;
  }
}
