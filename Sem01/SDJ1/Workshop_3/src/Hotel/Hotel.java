package Hotel;

public class Hotel
{
  private String name;
  private Room[] rooms;

  public Hotel(String name, Room[] room)
  {
    this.name = name;
    this.rooms = room;
  }

  public String getName()
  {
    return name;
  }

  public int getNumberOfRooms()
  {
    return rooms.length;
  }

  public int getNumberOfAvailableRooms()
  {
    int number = 0;
    for (int i = 0; i < rooms.length; i++)
    {
      if (!rooms[i].isOccupied())
      {
        number++;
      }
    }
    return number;
  }

  public Room getFirstAvailableRoom()
  {
    for (int i = 0; i < rooms.length; i++)
    {
      if (!rooms[i].isOccupied())
      {
        return rooms[i];
      }
    }
    return null;
  }

  public Room getFirstAvailableRoom(double maxPrice)
  {
    for (int i = 0; i < rooms.length; i++)
    {
      if (!rooms[i].isOccupied() && maxPrice > rooms[i].getPrice())
      {
        return rooms[i];
      }
    }
    return null;
  }

  public Room[] getAllAvailableRooms(String bedType)
  {
    Room[] temp;
    temp = new Room[getNumberOfAvailableRooms()];

    for (int i = 0; i < rooms.length; i++)
    {

      if (rooms[i].getGuest() == null && rooms[i].getBedType().equals(bedType))
      {
        for (int x = 0; x < temp.length; x++)
        {
          if (temp[x] == null)
          {
            temp[x] = rooms[i];
            break;

          }
        }
      }

    }
    return temp;
  }

  public boolean hasGuest(Room room)
  {
    return room.isOccupied();
  }

  public Room getRoom(Guest guest)
  {
    for (int i = 0; i < rooms.length; i++)
    {
      if (rooms[i].getGuest() == guest)
      {
        return rooms[i];
      }
    }
    return null;
  }

  public static void main(String[] args)
  {
    Room[] room = new Room[4];

    Guest g1 = new Guest("Tomas");
    room[0] = new Room(500, "Double");
    room[1] = new Room(380, "Double");
    room[2] = new Room(360, "Double");
    room[3] = new Room(10, "Double");

    Hotel hotel = new Hotel("all star", room);
    System.out.println(hotel.getNumberOfRooms());
    System.out.println(hotel.getNumberOfAvailableRooms());
    System.out.println(hotel.hasGuest(room[1]));
    room[1].registerGuest(g1);
    System.out.println(hotel.hasGuest(room[1]));

    Room[] temp = hotel.getAllAvailableRooms("Double");
    for (int i = 0; i < temp.length; i++)
    {
      System.out.println(temp[i]);
    }
  }
}
