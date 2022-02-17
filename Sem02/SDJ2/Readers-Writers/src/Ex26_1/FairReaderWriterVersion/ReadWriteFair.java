package Ex26_1.FairReaderWriterVersion;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReadWriteFair implements ReadWrite
{
  private int i;
  private int readers = 0;
  private int writers = 0;
  private Queue<Thread> queue;

  public ReadWriteFair()
  {
    readers = 0;
    writers = 0;
    queue = new ArrayDeque<>();
  }

  public void write()
  {
    try
    {
      Thread.sleep(200);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    i++;
  }

  public int read()
  {
    try
    {
      Thread.sleep(500);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    return i;
  }

  @Override public synchronized void acquireRead()
  {
    queue.offer(Thread.currentThread());
    while (queue.peek() != Thread.currentThread())
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    while (writers > 0)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    readers++;
    queue.remove();
    notifyAll();
  }

  @Override public synchronized void releaseRead()
  {
    readers--;
    if (readers == 0)
    {
      notifyAll();
    }
  }

  @Override public synchronized void acquireWrite()
  {
    queue.offer(Thread.currentThread());
    while (queue.peek() != Thread.currentThread())
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    while (writers > 0)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    writers++;
    queue.remove();
    notifyAll();
  }

  @Override public synchronized void releaseWrite()
  {
    writers--;
    if (writers == 0)
    {
      notifyAll();
    }
  }
}
