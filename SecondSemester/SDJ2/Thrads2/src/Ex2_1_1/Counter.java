package Ex2_1_1;

public class Counter
{
  private int count;

  public Counter()
  {
    count = 0;
  }

  public synchronized void count()
  {
    count++;
  }

  public synchronized int getCount()
  {
    return count;
  }
}
