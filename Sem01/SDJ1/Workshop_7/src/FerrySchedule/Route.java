package FerrySchedule;

public class Route extends Trip
{
  private Harbor from, to;

  public Route(Harbor from, Harbor to)
  {
    this.from = from;
    this.to = to;
  }

  public Harbor getFrom()
  {
    return from;
  }

  public Harbor getTo()
  {
    return to;
  }

}
