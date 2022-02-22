package Champion;

import java.util.Objects;

public class Item
{
  private String itemName, itemDescription;
  private int itemPrice;
  public Item(String itemName,int itemPrice, String itemDescription)
  {
    this.itemName = itemName;
    this.itemDescription = itemDescription;
    this. itemPrice = itemPrice;
  }
  public Item(String itemName, int itemPrice) {
    this.itemName = itemName;
    this.itemPrice = itemPrice;
    this.itemDescription = "";
  }
  public int getItemPrice()
  {
    return itemPrice;
  }
  public String getItemDescription() {
    return itemDescription;
  }
  public String getItemName() {
    return itemName;
  }
  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }
  public void setItemName(String itemName)
  {
    this.itemName = itemName;
  }
  public void setItemPrice(int itemPrice)
  {
    this.itemPrice = itemPrice;
  }
public void set (String itemName,int itemPrice, String itemDescription)
{
  this.itemDescription = itemDescription;
  this.itemPrice = itemPrice;
  this.itemName = itemName;
}
public String getItemFullDescription()
{
  return itemDescription;
}
  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Item item = (Item) o;
    return itemPrice == item.itemPrice && Objects
        .equals(itemName, item.itemName) && Objects
        .equals(itemDescription, item.itemDescription);
  }

  @Override public int hashCode()
  {
    return Objects.hash(itemName, itemDescription, itemPrice);
  }

  public String toString() {
    return "Item{" + "itemName='" + itemName + '\'' + ", itemDescription='"
        + itemDescription + '\'' + ", itemPrice=" + itemPrice + '}';
  }
}
