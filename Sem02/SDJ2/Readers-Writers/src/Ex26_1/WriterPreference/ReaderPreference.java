package Ex26_1.WriterPreference;

public class ReaderPreference implements ReadWrite
{
  private int i;
  private int readers = 0;
  private int writers = 0;
  private int waitingReaders = 0;
  private int waitingWriters = 0;

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
    waitingReaders++;
    while (writers > 0 || waitingWriters > 0)
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
    waitingReaders--;
    readers++;
  }

  @Override public synchronized void releaseRead()
  {
    readers--;
    if (readers == 0)
    {
      notify();
    }
  }

  @Override public synchronized void acquireWrite()
  {
    waitingWriters++;
    while (readers > 0 || writers > 0)
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
    waitingWriters--;
    writers++;
  }

  @Override public synchronized void releaseWrite()
  {
    writers--;
    notifyAll();
  }
}
