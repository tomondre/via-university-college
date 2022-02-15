package Itms;

import java.util.ArrayList;

public class ItemList
{
  ArrayList<Item> items;

  public ItemList()
  {
    items = new ArrayList<Item>();
  }

  public void addItem(Item item)
  {
    items.add(item);
  }

  public Item getItem(int index)
  {
    return items.get(index);
  }

  public Item[] getAllItems()
  {
    return items.toArray(new Item[items.size()]);
  }

  public Item[] getAllItems(String type)
  {
    ArrayList<Item> temp = new ArrayList<Item>();
    for (Item item : items)
    {
      if (item.getType().equals(type))
      {
        temp.add(item);
      }

    }
    return temp.toArray(new Item[temp.size()]);
  }

  public double getTotalPrice()
  {
    double total = 0;
    for (Item item : items)
    {
      total += item.getPrice();
    }
    return total;
  }
}
