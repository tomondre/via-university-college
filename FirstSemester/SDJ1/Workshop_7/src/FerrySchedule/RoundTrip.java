package FerrySchedule;

public class RoundTrip extends Trip
{
  private Harbor harbor;

  public RoundTrip(Harbor harbor)
  {
    this.harbor = harbor;
  }

  public Harbor getFrom()
  {
    return harbor;
  }

  public Harbor getTo()
  {
    return harbor;
  }
}
