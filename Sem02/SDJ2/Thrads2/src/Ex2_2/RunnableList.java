package Ex2_2;

public class RunnableList implements Runnable
{

  private ListContainer container;

  public RunnableList(ListContainer container)
  {
    this.container = container;
  }

  public void run()
  {
    for (int i = 0; i < 1000000; i++)
    {
      container.add(i);
    }

    System.out.println(container.length());
  }

}
