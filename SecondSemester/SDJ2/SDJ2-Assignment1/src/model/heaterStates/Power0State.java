package model.heaterStates;

import model.Heater;

public class Power0State implements HeaterState
{
  private final int POWER = 0;

  @Override public void turnUp(Heater heater)
  {
    heater.setState(new Power1State());
  }

  @Override public void turnDown(Heater heater)
  {

  }

  @Override public int getPower()
  {
    return POWER;
  }
}
