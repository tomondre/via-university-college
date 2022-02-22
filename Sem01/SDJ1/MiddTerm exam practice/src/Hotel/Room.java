package Hotel;

public class Room
{
  private Guest guest;
  private Bed bed;
  private int number;

  public Room(int number, String bedType)
  {
    this.number = number;
    bed = new Bed(bedType);
    guest = null;
  }

  public int getNumber()
  {
    return number;
  }

  public int getFloor()
  {
    return number / 100;
  }

  public double getPrice()
  {
    if (bed.isKingSize())
    {
      return 89;
    }
    else if (bed.isDouble())
    {
      return 72.40;
    }
    else if (bed.isSingle())
    {
      return 59.50;
    }
    else
      return 0;
  }

  public boolean isOccupied()
  {
    return !(guest == null);
  }

  public void registerGuest(Guest guest)
  {
    this.guest = guest;
  }

  public void vacate()
  {
    guest = null;
  }

  public String getBedType()
  {
    if (bed.isKingSize())
    {
      return "King size";
    }
    else if (bed.isDouble())
    {
      return "Double";
    }
    else if (bed.isSingle())
    {
      return "Single";
    }
    else
      return "";
  }

  public Guest getGuest()
  {
    return guest;
  }
}
