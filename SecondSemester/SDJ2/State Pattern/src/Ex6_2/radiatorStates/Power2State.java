package Ex6_2.radiatorStates;

import Ex6_2.Radiator;

public class Power2State implements RadiatorState
{
private static int POWER = 2;

  @Override public void turnUp(Radiator radiator)
  {
radiator.setPowerState(new Power3State(radiator));
  }

  @Override public void turnDown(Radiator radiator)
  {
radiator.setPowerState(new Power1State());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
