package Ex26_1.FairReaderWriterVersion;

public class Reader implements Runnable
{
  private ReadWrite lock;
  private int readerNumber;

  public Reader(ReadWrite lock, int readerNumber)
  {
    this.lock = lock;
    this.readerNumber = readerNumber;
  }

  @Override public void run()
  {
    while (true)
    {
      spendTime(1000, 2000);

      lock.acquireRead();
      Log.getInstance().log("Reader " + readerNumber + "> read acquired");
      spendTime(500, 1000);

      lock.releaseRead();
      Log.getInstance().log("Reader " + readerNumber + "> read released");
    }
  }

  private void spendTime(int min, int max)
  {
    long time = (long) (Math.random() * (max - min) + min);
    try
    {
      Thread.sleep(time);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
