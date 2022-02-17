package model;

import java.util.ArrayList;

public interface Model extends PropertyChangeSubject
{
  ArrayList<Double> getThermometerHistory(int thermometerID);

  double getLastThermometerValue(int thermometerID);

  int getHeaterLevel();

  void turnHeaterUp();

  void turnHeaterDown();

  boolean outsideCriticalValues();

  void setHighCriticalValue(Double value);

  void setLowCriticalValue(Double value);

  double getHighCriticalValue();

  double getLowCriticalValue();
}
