package Itms;

public abstract class Item
{
  private double price;

  public Item(double price)
  {
    this.price = price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public double getPrice()
  {
    return price;
  }

  public String toString()
  {
    return "Price: " + price;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Item))
    {
      return false;
    }
    Item other = (Item)obj;
    return price == other.price;
  }
public abstract String getType();
}
