package Ex2_6;

import java.util.ArrayList;

public class Bar
{
  private ArrayList<Beer> beers;
  private int maxBeers;

  public Bar(int maxBeers)
  {
    beers = new ArrayList<Beer>();
    this.maxBeers = maxBeers;
  }

  public synchronized void placeBeer(Beer b)
  {
    while (beers.size() >= maxBeers)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
      }
    }
    beers.add(b);
    notifyAll();
  }

  public synchronized void takeBeer()
  {
    notifyAll();
    if (beers.size()==0)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
      }
    }
    beers.remove(0);
  }

public synchronized int numberOfBeers()
{
  return beers.size();
}

}
