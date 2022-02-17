package Ex6_2.radiatorStates;

import Ex6_2.Radiator;

public interface RadiatorState
{
  void turnUp(Radiator radiator);
  void turnDown(Radiator radiator);
  int getPower();
}
