package Ex26_1.FairReaderWriterVersion;

public class Writer implements Runnable
{
  private ReadWrite lock;
  private int writerNumber;

  public Writer(ReadWrite lock, int writerNumber)
  {
    this.writerNumber = writerNumber;
    this.lock = lock;
  }

  @Override public void run()
  {
    while (true)
    {
      spendTime(1000, 2000);

      Log.getInstance().log("Writer " + writerNumber + "> write acquired");
      lock.acquireWrite();

      spendTime(3000, 4000);

      lock.releaseWrite();
      Log.getInstance().log("Writer " + writerNumber + "> write released");
    }
  }

  private void spendTime(int min, int max)
  {
    long time = (long) (Math.random() * (max - min) + min);
    try
    {
      Thread.sleep(time);
    }
    catch(InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
