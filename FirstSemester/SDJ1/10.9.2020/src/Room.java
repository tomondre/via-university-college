public class Room
{
  private int block, floor, seats;
  private boolean projector;

  public Room (int block, int floor, int seats, boolean projector)
  {
    this.block = block;
    this.floor =  floor;
    this.seats = seats;
    this.projector = projector;
  }
  public Room (int block, int floor, boolean projector)
  {
    this.block = block;
    this.floor =  floor;
    this.projector = projector;
  }
  public void setSeats(int seats)
  {
    this.seats = seats;
  }
  public void setProjector(boolean projector)
  {
    this.projector = projector;
  }
  public int getBlock()
  {
    return block;
  }
  public int getFloor()
  {
    return floor;
  }
  public int getSeats()
  {
    return seats;
  }
 public boolean getProjector()
 {
  return projector;
 }
}


