package fifth;

public class Start
{
  public static void main(String[] args)
  {
    Thread t1 = new Thread(new Run(0,25000, null));
    Thread t2 = new Thread(new Run(25000,50000, t1));
    Thread t3 = new Thread(new Run(50000,75000, t2));
    Thread t4 = new Thread(new Run(75000,100000, t3));

  t1.start();
  t2.start();
  t3.start();
  t4.start();
  }
}
