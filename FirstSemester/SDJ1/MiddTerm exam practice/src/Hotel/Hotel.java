package Hotel;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.ArrayList;

public class Hotel
{
  private ArrayList<Room> rooms;
  private String name;

  public Hotel(String name, Room[] roooms)
  {
    this.name = name;
    this.rooms = new ArrayList<Room>(roooms.length);
    for (int i = 0; i < roooms.length; i++)
    {
      rooms.add(roooms[i]);
    }
  }

  public String getName()
  {
    return name;
  }

  public int getNumberOfRooms()
  {
    return rooms.size();
  }

  public int getNumberOfAvailableRooms()
  {
    int temp = 0;
    for (int i = 0; i < rooms.size(); i++)
    {
      if (!rooms.get(i).isOccupied())
      {
        temp++;
      }
    }
    return temp;
  }

  public Room getFirstAvailableRoom()
  {


    for (int i = 0; i < rooms.size(); i++)
    {
      if (!(rooms.get(i).isOccupied()))
      {
        return rooms.get(i);
      }
    }
    return null;
  }

  public Room getFirstAvailableRoom(double maxPrice)
  {
    int temp = 0;
    for (int i = 0; i < rooms.size(); i++)
    {
      if (!(rooms.get(i).isOccupied()) && rooms.get(i).getPrice() < maxPrice)
      {
        return rooms.get(i);
      }
    }
    return null;
  }

  public Room[] getAllAvailableRooms(String bedType)
  {
    ArrayList<Room> temp = new ArrayList<Room>();

    for (int i = 0; i < rooms.size(); i++)
    {
      if (rooms.get(i).getBedType().equals(bedType) && !(rooms.get(i)
          .isOccupied())) {
      temp.add(rooms.get(i));
    }
    } return temp.toArray(new Room[temp.size()]);
  }

  public boolean hasRoom(Guest guestt)
  {
    for (int i = 0; i < rooms.size(); i++)
    {
      if (rooms.get(i).getGuest()==null)
      {
        return false;
      }
      if (rooms.get(i).getGuest().equals(guestt))
      {
        return true;
      }
    }
    return false;
  }

  public Room getRoom(Guest guest)
  {
    for (int i = 0; i < rooms.size(); i++)
    {
      if (rooms.get(i).getGuest().equals(guest))
      {
        return rooms.get(i);
      }
    }
    return null;

  }

  public static void main(String[] args)
  {

    Guest guest = new Guest("Peter");
    Room[] room = new Room[2];
    room[0] = new Room(205,"Single");
    room[1] = new Room(306,"Single");

    Hotel hotel = new Hotel("Janosik",room);
    System.out.println(hotel.getFirstAvailableRoom());
    System.out.println(hotel.getFirstAvailableRoom(70));
    Room[] rooms = hotel.getAllAvailableRooms("Single");
    for(Room r :rooms)
    {
      System.out.println(r);
    }
    System.out.println(hotel.hasRoom(guest));
    hotel.getFirstAvailableRoom().registerGuest(guest);
    System.out.println(hotel.hasRoom(guest));





  }



}


