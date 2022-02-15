package Ex2_5;

public class Program implements Runnable
{
  private String program;
  private String action;
  private int count;
  private final long RUNTIME = 100000;

  public Program(String program, String action, int count)
  {
    this.program = program;
    this.action = action;
    this.count = count;
  }

  @Override public void run()
  {
    if (program.equals("Windows"))
    {
      System.out.println("Windows want auto update");
    }
    else if (program.equals("AVG"))
    {
      System.out.println("");
    }
    else if (program.equals("FBackup"))
    {
      System.out.println("New mail in your mailbox..");
    }
    else if (program.equals("Skype"))
    {
      System.out.println("Skype wants to notify you about a person logging in");
    }
    try
    {
      Thread.sleep(RUNTIME / 30);
    }
    catch (InterruptedException e)
    {
    }
  }
}
