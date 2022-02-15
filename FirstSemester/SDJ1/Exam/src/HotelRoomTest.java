public class HotelRoomTest
{
  public static void main(String[] args)
  {
    HotelRoom r1 = new HotelRoom(20,200);
    HotelRoom r2 = new HotelRoom(10,100);
    HotelRoom r3 = new HotelRoom(5,50);
r1.setRent(300);
Guest g1 = new Guest("Peter");

    Guest g2 = new Guest("Marek");

    r1.checkIn(g1);
    r2.checkIn(g2);
    System.out.println(r1);
    System.out.println(r2.isAvailable());
r2.checkOut();
    System.out.println(r2);
    System.out.println(r2.isAvailable());
  }
}
