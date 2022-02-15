package Customer;

import java.util.ArrayList;

public class Invoice
{
  private Customer customer;
  private ArrayList<Item> items;

  public Invoice(Customer customer)
  {
    this.customer = customer;
    items = new ArrayList<Item>();
  }

  public void addItem(Item item)
  {
    items.add(item);
  }

  public void removeItem(Item item)
  {
    items.remove(item);
  }

  public double getTotalPrice()
  {
    int temp = 0;
    for (Item item : items)
    {
      temp += item.getPrice();
    }
    return temp;
  }

  public int getNumberOfItems()
  {
    return items.size();
  }

  public Item[] getListOfITems()
  {
    return items.toArray(new Item[getNumberOfItems()]);
  }

  public Item[] getListOfFragileItems()
  {
    ArrayList<Item> temp = new ArrayList<Item>();
    for (Item item : items)
    {
      if (item.isFragile())
      {
        temp.add(item);
      }
    }
    return temp.toArray(new Item[temp.size()]);
  }

  public int getNumberOfFragileItems()
  {
    int temp = 0;
    for (Item item : items)
    {
      if (item.isFragile())
      {
        temp++;
      }
    }
    return temp;
  }

  public Item[] getSortedListOfFragileItems()
  {
    Item temp;
    boolean working = true;
    Item[] tempList = new Item[getNumberOfFragileItems()];
    for (int i = 0; i < items.size(); i++)
    {
      if (tempList[i].isFragile())
      {
        tempList[i] = items.get(i);
      }
    }
    while (working)
  {
    working = false;
    for (int i = 0; i < items.size() - 1; i++)
    {
      if (tempList[i].getPrice() > tempList[i + 1].getPrice()
          && i < tempList.length - 1)
      {
        temp = tempList[i];
        tempList[i] = tempList[i + 1];
        tempList[i + 1] = temp;
        working = true;
      }
    }
  }
    return tempList;
  }

  public String getCustomerType()
  {
    return customer.getType();
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Invoice))
    {
      return false;
    }

    Invoice other = (Invoice) obj;
    return items.equals(other.items) && customer.equals(other.customer)
        && getTotalPrice() == other.getTotalPrice();
  }

  public String toString()
  {
    return "Total price: " + getTotalPrice() + ", Customer: " + customer;
  }
}