public class HotelRoom
{
  int roomNumber;
  double rent;
  Guest newGuest = new Guest(null);

  public HotelRoom(int roomNumber, double rent)
  {
    this.roomNumber = roomNumber;
    this.rent = rent;
    Guest guest = new Guest(null);
  }

  public int getRoom()
  {
    return roomNumber;
  }

  public double getRent()
  {
    return rent;
  }

  public String getGuest(Guest n)
  {
    return n.name;
  }

  public void setRent(double rent)
  {
    this.rent = rent;
  }

  public boolean isAvailable()
  {
    if (newGuest.getName() == null)
    {
      return true;
    }
    else
    {
      return false;
    }
    }

  public void checkIn(Guest guest)
  {
    if (isAvailable() == true)
    {
      newGuest = guest;
    }
  }

  public void checkOut()
  {
    newGuest = null;

  }

  @Override public String toString()
  {
    return "HotelRoom{" + "roomNumber=" + roomNumber + ", rent=" + rent
        + "=" + newGuest.getName() + '}';
  }
}


