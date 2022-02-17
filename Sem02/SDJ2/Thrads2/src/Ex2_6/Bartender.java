package Ex2_6;

public class Bartender implements Runnable
{
  private Bar bar;

  public Bartender(Bar bar)
  {
    this.bar = bar;
  }

  @Override public void run()
  {
    Beer beer = new Beer(25);
    while(true)
    {
      bar.placeBeer(beer);

      try
      {
        Thread.sleep(2000);
        System.out.println("Beer placed, number of beers: " + bar.numberOfBeers());
      }
      catch (InterruptedException e) {
        System.out.println("Bar is full");
      }
    }


  }
}
