package model.heaterStates;

import model.Heater;

public interface HeaterState
{
  void turnUp(Heater heater);
  void turnDown(Heater heater);
  int getPower();
}
