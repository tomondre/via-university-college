package Vehicle;

public class Van extends Car
{
  private int maxLoad;

  public Van(String owner, double price, String regNo, int maxLoad)
  {
    super(owner, price, regNo);
    this.maxLoad = maxLoad;
  }

  public int getMaxLoad()
  {
    return maxLoad;
  }

  public String toString()
  {
    return super.toString() + " maxLoad: " + maxLoad;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Van))
    {
      return false;
    }
    Van other = (Van) obj;
    return super.equals(other) && maxLoad == other.maxLoad;
  }
}
