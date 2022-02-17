package sixth;

public class PokingMan implements Runnable
{
  private Thread bearThread;
  private Bear bear;

  public PokingMan(Thread bearThread)
  {
    this.bearThread=bearThread;
    bear=null;
  }

  @Override public void run()
  {
    bearThread.interrupt();
  }
}
