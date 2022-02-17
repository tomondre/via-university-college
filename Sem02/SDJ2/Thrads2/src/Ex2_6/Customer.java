package Ex2_6;

public class Customer implements Runnable
{

  private Bar bar;

  public Customer(Bar bar)
  {
    this.bar = bar;
  }

  @Override public void run()
  {
    while (true)
    {
      bar.takeBeer();
      try
      {
        Thread.sleep(4000);
        System.out.println("Beer taken, number of beers: " + bar.numberOfBeers());
      }
      catch (InterruptedException e) {
        System.out.println("Bar is full");
      }
    }
  }
}
