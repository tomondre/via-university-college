public class HotelRoom
{
  private int number;
  private String name;
  private double price;
  private Guest guest;
  private double SINGLE_PRICE = 59.50;
  private double DOUBLE_PRICE = 68.50;
  private double FAMILY_PRICE = 99.25;
  public HotelRoom(int number, String name)
  {
    this.number = number;
    this.name = name;
  }

  public int getNumber()
  {
    return number;
  }

  public String getName()
  {
    return name;
  }

  public double getPrice()
  {
    return price;
  }

  public Guest getGuest()
  {
    return guest;
  }

  public int getFloor()
  {
    return number / 100;
  }

  public boolean isOccupied()
  {
    if (guest == null)
    {
      return false;
    }
    else
      return true;
  }

  public void registerGuest(Guest guest)
  {
    this.guest = guest;
  }

  public void vacate()
  {
    guest = null;
  }

  @Override public String toString()
  {
    return "HotelRoom{" + "number=" + number + ", name='" + name + '\''
        + ", price=" + price + ", guest=" + guest + '}';
  }

  public static double getRoomPrice(String type)
  {
    switch (type)
    {
      case "Single":
        return 59.50;
      case "Double":
        return 68.50;
      case "Family":
        return 99.25;
      default:
        return 0;
    }

  }
}
