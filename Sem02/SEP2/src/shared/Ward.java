package shared;

import java.io.Serializable;

public class Ward implements Serializable
{
  private String wardName;
  private int roomNumber;

  public Ward(String wardName, int roomNumber)
  {
    this.wardName = wardName;
    this.roomNumber = roomNumber;
  }

  public String getWardName()
  {
    return wardName;
  }

  public int getRoomNumber()
  {
    return roomNumber;
  }

  public void setWardName(String wardName)
  {
    this.wardName = wardName;
  }

  public void setRoomNumber(int roomNumber)
  {
    this.roomNumber = roomNumber;
  }

  @Override
  public String toString()
  {
    return wardName + ' ' + roomNumber;
  }

  public Ward copy()
  {
    return new Ward(wardName, roomNumber);
  }
}
