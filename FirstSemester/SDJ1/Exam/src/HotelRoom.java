public class HotelRoom
{
  int roomNumber;
  double rent;
  private Guest guest;
  public HotelRoom(int roomNumber, double rent)
  {
    this.roomNumber = roomNumber;
    this.rent = rent;
    guest = null;
  }
  public int getRoom()
  {
    return roomNumber;
  }
  public double getRent()
  {
    return rent;
  }
  public String getGuest()
  {
    return guest.getName();
  }
  public void setRent(double rent)
  {
    this.rent = rent;
  }
  public boolean isAvailable()
  {
    if (guest == null)
    {
      return true;
    }
    else
      return false;
  }
  public void checkIn(Guest guest)
  {
    if (isAvailable() == true)
    {
      this.guest = guest;
    }
  }
  public void checkOut()
  {
    this.guest  = null;
  }
  @Override public String toString()
  {
    return "HotelRoom{" + "roomNumber=" + roomNumber + ", rent=" + rent
        + "=" + guest + '}';
  }
}


