package FerrySchedule;

public class Departure
{
  private String dayAndTime;
  private Trip trip;

  public Departure(String dayAndTime, Trip trip)
  {
    this.trip = trip;
    this.dayAndTime = dayAndTime;
  }

  public String getDayAndTime()
  {
    return dayAndTime;
  }

  public Harbor getFrom()
  {
    return trip.getFrom();
  }

  public Harbor getTo()
  {
    return trip.getTo();
  }
}
