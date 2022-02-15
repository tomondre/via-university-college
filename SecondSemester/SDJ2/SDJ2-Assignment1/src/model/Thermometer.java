package model;

import java.util.ArrayList;

public class Thermometer implements Runnable
{
  private final int minOutdoorTemperature = -20;
  private final int maxOutdoorTemperature = 20;

  private final int thermometerID;
  private final int heaterDistance;
  private final HeatingSystem system;
  private final ThermometerLog log;
  private final Thermometer externalThermometer;

  public Thermometer(int thermNum, HeatingSystem system, int heaterDistance,
      Thermometer externalThermometer)
  {
    this.thermometerID = thermNum;
    this.system = system;
    this.heaterDistance = heaterDistance;
    log = new ThermometerLog();
    this.externalThermometer = externalThermometer;
  }

  public void run()
  {
    int s;
    while (true)
    {
      s = (int) (Math.random() * 5 + 4);
      try
      {
        Thread.sleep(s * 1000);
        double temp;

        //model.Thermometer for external thermometer
        //Adds temperature to history and fire an Event with thermometer identifier and new value
        if (externalThermometer == null)
        {
          temp = externalTemperature(log.getLastValue(), minOutdoorTemperature,
               maxOutdoorTemperature);
        }

        //Method for internal thermometer
        //Adds temperature to history and fire an Event with thermometer identifier and new value
        else
        {
          temp = temperature(log.getLastValue(), system.getHeatingPower(),
              heaterDistance, externalThermometer.getLastValue(), s);

          if (temp > system.getMaxCriticalValue())
          {
            system.firePropertyChange("ErrorMax", -1, 0);
          }
          if (temp < system.getMinCriticalValue())
          {
            system.firePropertyChange("ErrorMin", -1, 0);
          }
        }

        log.add(temp);
        system.firePropertyChange("ThermometerChange", thermometerID, temp);

      }
      catch (InterruptedException e)
      {
      }
    }
  }

  public double getLastValue()
  {
    return log.getLastValue();
  }

  /*** Calculating the internal temperature in one of two locations.
   * This includes a term from a heater (depending on location and
   * heaters power), and a term from an outdoor heat loss.
   * Values are only valid in the outdoor temperature range [-20; 20]
   * and when s, the number of seconds between each measurements are
   * between 4 and 8 seconds.
   * @param t  the last measured temperature
   * @param p  the heaters power {0, 1, 2 or 3} where 0 is turned off,
   * 1 is low, 2 is medium and 3 is high
   * @param t0 the outdoor temperature (valid in the range [-20; 20])
   * @param s the number of seconds since last measurement[4; 8]
   * @return the temperature*/
  public double temperature(double t, int p, int d, double t0, int s)
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

  /**
   * Calculating the external temperature.
   * Values are only valid if the temperature is being measured
   * approximately every 10th second.
   *
   * @param t0  the last measured external temperature
   * @param min a lower limit (may temporally be deceeded)
   * @param max an upper limit (may temporally be exceeded)
   * @return an updated external temperature
   */
  public double externalTemperature(double t0, double min, double max)
  {
    double left = t0 - min;
    double right = max - t0;
    int sign = Math.random() * (left + right) > left ? 1 : -1;
    t0 += sign * Math.random();
    return t0;
  }

  public ArrayList<Double> getHistory()
  {
    return log.getHistoryValues();
  }

  public int getID()
  {
    return thermometerID;
  }
}
