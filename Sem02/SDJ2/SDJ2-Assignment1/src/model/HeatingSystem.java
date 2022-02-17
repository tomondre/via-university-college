package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class HeatingSystem implements Model
{
  private double maxCriticalValue = 30;
  private double minCriticalValue = 10;

  private final Heater heater;
  private final PropertyChangeSupport propertyChangeSupport;

  //Internal thermometers in list has externalThermometer field set to null.
  private final Thermometer[] thermometers;
  private final Thread[] threads;

  public HeatingSystem()
  {
    propertyChangeSupport = new PropertyChangeSupport(this);
    heater = new Heater(this);

    thermometers = new Thermometer[3];
    thermometers[0] = new Thermometer(0, this, 0, null);
    thermometers[1] = new Thermometer(1, this, 1, thermometers[0]);
    thermometers[2] = new Thermometer(2, this, 7, thermometers[0]);

    threads = new Thread[thermometers.length];
    for (int i = 0; i < threads.length; i++)
    {
      threads[i] = new Thread(thermometers[i]);
      threads[i].setDaemon(true);
      threads[i].start();
    }
  }

  public int getHeatingPower()
  {
    return heater.getPower();
  }

  @Override public ArrayList<Double> getThermometerHistory(int thermometerID)
  {
    for (Thermometer thermometer : thermometers)
    {
      if (thermometer.getID() == thermometerID)
      {
        return thermometer.getHistory();
      }
    }
    return null;
  }

  @Override public double getLastThermometerValue(int thermometerID)
  {
    for (Thermometer thermometer : thermometers)
    {
      if (thermometer.getID() == thermometerID)
      {
        return thermometer.getLastValue();
      }
    }
    return 0;
  }

  @Override public int getHeaterLevel()
  {
    return heater.getPower();
  }

  @Override public void turnHeaterUp()
  {
    heater.turnUp();
  }

  @Override public void turnHeaterDown()
  {
    heater.turnDown();
  }

  //Checks if ant thermometer is outside of pre defined critical fields
  @Override public boolean outsideCriticalValues()
  {
    for (int i = 1; i < thermometers.length; i++)
    {
      double thermValue = thermometers[i].getLastValue();

      if (thermValue > maxCriticalValue || thermValue < minCriticalValue)
      {
        return true;
      }
    }
    return false;
  }

  @Override public void setHighCriticalValue(Double value)
  {
    maxCriticalValue = value;
  }

  @Override public void setLowCriticalValue(Double value)
  {
    minCriticalValue = value;
  }

  @Override public double getHighCriticalValue()
  {
    return maxCriticalValue;
  }

  @Override public double getLowCriticalValue()
  {
    return minCriticalValue;
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }

  @Override public void firePropertyChange(String propertyName,
      int thermometerID, double newValue)
  {
    propertyChangeSupport
        .firePropertyChange(propertyName, thermometerID, newValue);
  }

  public double getMaxCriticalValue()
  {
    return maxCriticalValue;
  }

  public double getMinCriticalValue()
  {
    return minCriticalValue;
  }
}

