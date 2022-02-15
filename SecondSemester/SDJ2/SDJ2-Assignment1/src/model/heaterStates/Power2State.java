package model.heaterStates;

import model.Heater;

public class Power2State implements HeaterState
{
  private final int POWER = 2;

  @Override public void turnUp(Heater heater)
  {
    heater.setState(new Power3State(heater));
  }

  @Override public void turnDown(Heater heater)
  {
    heater.setState(new Power1State());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
