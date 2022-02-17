package Ex2_1_2;

public class Start
{
  public static void main(String[] args)
  {

    TryLockCounter counter = new TryLockCounter();
    TryLockCounter c2 = new TryLockCounter();

    Thread st = new Thread(new Invoking(counter, c2));
    Thread a = new Thread(new Invoking(counter, c2));
    Thread s = new Thread(new Invoking(counter, c2));
    Thread t = new Thread(new Invoking(counter, c2));
    Thread ast = new Thread(new Invoking(counter, c2));

    st.start();
    a.start();
    s.start();
    t.start();
    ast.start();

  }
}