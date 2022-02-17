package Ex2_5;

public class MailBox implements Runnable
{
  private int count;
  private static final long RUNTIME = 100000;

  public MailBox(int count)
  {
    this.count = count;
  }

  @Override public void run()
  {
    System.out.println("New mail in your mailbox...");
    try
    {
      Thread.sleep(RUNTIME / 30);
    }
    catch (InterruptedException e)
    {
    }
  }
}
