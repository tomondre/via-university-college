package Ex6_3.model.doorStates;

import Ex6_3.model.Door;

public class CloseDoorState implements DoorState
{
  @Override public void pressButton(Door door)
  {
    door.setDoorState(new OpeningDoorState(door));
  }

  @Override public String getState()
  {
    return "Door closed";
  }

}
