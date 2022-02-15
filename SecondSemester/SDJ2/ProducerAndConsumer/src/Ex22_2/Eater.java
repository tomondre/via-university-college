package Ex22_2;

public class Eater implements Runnable
{
  private BlockingQueue queue;
  private int eaterNumber;

  public Eater(BlockingQueue queue, int eaterNumber)
  {
    this.queue = queue;
    this.eaterNumber = eaterNumber;
  }

  @Override public void run()
  {
    while (true)
    {
      synchronized (this)
      {
        while (queue.size() == 0)
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
        queue.take();

        System.out.println("Eater Number " + eaterNumber + "has taken carrot");

        notify();

        try
        {
          Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }
  }
}
