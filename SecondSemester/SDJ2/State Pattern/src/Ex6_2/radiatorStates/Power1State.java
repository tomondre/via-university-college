package Ex6_2.radiatorStates;

import Ex6_2.Radiator;

public class Power1State implements RadiatorState
{
  private static int POWER = 1;

  @Override public void turnUp(Radiator radiator)
  {
    radiator.setPowerState(new Power2State());
  }

  @Override public void turnDown(Radiator radiator)
  {
    radiator.setPowerState(new OffState());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
