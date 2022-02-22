package Customer;

public class Item
{
  private double price;
  private boolean fragile;

  public Item(double price, boolean fragile)
  {
    this.price = price;
    this.fragile = fragile;
  }

  public double getPrice()
  {
    return price;
  }

  public boolean isFragile()
  {
    return fragile;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Item))
    {
      return false;
    }
    Item other = (Item) obj;
    return price == other.price && fragile == other.fragile;
  }
  public String toString()
  {
    return "Price: " + price + ", fragile " + fragile;
  }
}
