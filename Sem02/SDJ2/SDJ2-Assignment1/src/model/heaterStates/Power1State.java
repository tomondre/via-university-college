package model.heaterStates;

import model.Heater;

public class Power1State implements HeaterState
{
  private final int POWER = 1;

  @Override public void turnUp(Heater heater)
  {
    heater.setState(new Power2State());
  }

  @Override public void turnDown(Heater heater)
  {
    heater.setState(new Power0State());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
