package Ex2_1_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockCounter
{
  private int count;
  private Lock lock = new ReentrantLock();

  public void inc()
  {
    while (lock.tryLock())
    {
      try
      {
        wait(10000);
      }
      catch (InterruptedException | IllegalStateException e)
      {

      }
      count++;
      lock.unlock();
      System.out.println("Lock was in use");
    }
  }

  public synchronized int get()
  {
    return count;
  }

}
