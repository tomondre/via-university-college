package seventh;

public class CounterIncremeter implements Runnable
{
    private Counter counter;


    public CounterIncremeter(Counter counter){
      this.counter = counter;
    }

  @Override public void run()
  {
    for (int i = 0; i < 1000000; i++)
    {
      counter.cunt();
    }
    System.out.println(counter.getCount());
  }
}
