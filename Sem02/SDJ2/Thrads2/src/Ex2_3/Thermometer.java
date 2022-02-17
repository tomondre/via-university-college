package Ex2_3;

public class Thermometer implements Runnable
{

  private String id;
  private double t;

  public Thermometer(String id, double t)
  {
    this.id = id;
    this.t = t;
  }

  /**
   * Calculating the temperature measured in one of two locations.
   * This includes a term from a heater (depending on location and
   * heaters power), and a term from an outdoor heat loss.
   * Values are only valid in the outdoor temperature range [-20; 20]
   * and when s, the number of seconds between each measurements are
   * between 4 and 8 seconds.
   *
   * @param t  the last measured temperature
   * @param p  the heaters power {0, 1, 2 or 3} where 0 is turned off,
   *           1 is low, 2 is medium and 3 is high
   * @param d  the distance between heater and measurements {1 or 7}
   *           where 1 is close to the heater and 7 is in the opposite corner
   * @param t0 the outdoor temperature (valid in the range [-20; 20])
   * @param s  the number of seconds since last measurement [4; 8]
   * @return the temperature
   */

  private double temperature(double t, int p, int d, double t0, int s)

  {
    double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
    tMax = Math.max(Math.max(t, tMax), t0);
    double heaterTerm = 0;
    if (p > 0)
    {
      double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);

      heaterTerm = 30 * s * Math.abs(tMax - t) / den;
    }
    double outdoorTerm = (t - t0) * s / 250.0;
    t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);
    return t;
  }

  @Override public void run()
  {
    while (true)
    {
      t = temperature(t, 0, 1, 0, 6);
      System.out.println("T: " + t + ", ID: " + id);
      try
      {
        Thread.sleep(100);
      }
      catch (InterruptedException e)
      {
        System.out.println("E");
      }
    }
  }
}
