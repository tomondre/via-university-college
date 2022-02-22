package Hotel;

public class Room
{
  private int number;
  private Bed bed;
  private Guest guest;

  public Room(int number, String bedType)
  {
    this.number = number;
    bed = new Bed(bedType);
  }

  public int getNumber()
  {
    return number;
  }

  public Guest getGuest()
  {
    return guest;
  }

  public int getFloor()
  {
    return number / 100;
  }

  public double getPrice()
  {
    if (bed.isDouble())
    {
      return 72.4;
    }
    if (bed.isKingSize())
    {
      return 89;
    }
    if (bed.isSingle())
    {
      return 59.5;
    }
    else
      return 0;
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

  public String getBedType()
  {
    if (bed.isSingle())
    {
      return "Single";
    }
    if (bed.isDouble())
    {
      return "Double";
    }
    if (bed.isKingSize())
    {
      return "King size";
    }
    else
      return "";
  }

  @Override public String toString()
  {
    return "Room{" + "number=" + number + ", bed=" + bed + ", guest=" + guest
        + '}';
  }
}
