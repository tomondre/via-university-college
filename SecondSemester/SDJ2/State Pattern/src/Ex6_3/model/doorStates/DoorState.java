package Ex6_3.model.doorStates;

import Ex6_3.model.Door;

public interface DoorState
{
   void pressButton(Door door);
   String getState();
}
