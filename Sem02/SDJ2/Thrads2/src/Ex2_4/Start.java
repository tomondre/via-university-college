package Ex2_4;

public class Start
{
  public static void main(String[] args)
  {
    Counter counter = new Counter(-50,50);

    CounterIncrement inc = new CounterIncrement(counter, 100);
    CounterDecrement dec = new CounterDecrement(counter, 20);
    CounterIncrement in = new CounterIncrement(counter, 100);
    CounterDecrement de = new CounterDecrement(counter, 20);

    Thread t1 = new Thread(inc);
    Thread t2 = new Thread(dec);
    Thread t3 = new Thread(in);
    Thread t4 = new Thread(de);

    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}
