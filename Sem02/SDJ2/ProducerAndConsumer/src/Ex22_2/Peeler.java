package Ex22_2;

public class Peeler implements Runnable
{
  private BlockingQueue queue;

  public Peeler(BlockingQueue queue)
  {
    this.queue = queue;
  }

  @Override public void run()
  {
    while (true)
    {
      synchronized (this)
      {
        while (queue.size() == queue.getCapacity())
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
        queue.put(new Carrot());

        System.out.println("Carrot created");
        notify();
        try
        {
          Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }
  }
}
