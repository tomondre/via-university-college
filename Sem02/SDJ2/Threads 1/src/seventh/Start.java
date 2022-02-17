package seventh;

public class Start
{
  public static void main(String[] args)
  {
    Counter c = new Counter();

    Thread t1 = new Thread(new CounterIncremeter(c));
    Thread t2 = new Thread(new CounterIncremeter(c));

    t1.start();
    t2.start();
  }
}
