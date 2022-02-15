package Ex2_2;

public class Start
{
  public static void main(String[] args)
  {

    ListContainer container = new ListContainer();
    ListContainer con = new ListContainer();

    Thread t1 = new Thread(new RunnableList(container));
    Thread t2 = new Thread(new RunnableList(container));

    t1.start();
    t2.start();

  }
}
