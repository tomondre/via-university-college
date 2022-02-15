package Ex2_1_2;

public class Invoking implements Runnable
{
  private TryLockCounter countDooku;
  private TryLockCounter countDracula;

  public Invoking(TryLockCounter countDooku, TryLockCounter countDracula)
  {
    this.countDooku = countDooku;
    this.countDracula = countDracula;
  }

  @Override public void run()
  {
    for (int i = 0; i < 1000000; i++)
    {
      countDooku.inc();
      countDracula.inc();
    }
    System.out.println(countDooku.get());
    System.out.println(countDracula.get());
  }
}
