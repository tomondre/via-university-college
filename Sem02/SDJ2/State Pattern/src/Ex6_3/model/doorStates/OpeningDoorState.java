package Ex6_3.model.doorStates;

import Ex6_3.model.Door;

public class OpeningDoorState implements DoorState
{
  Thread thread;

  public OpeningDoorState(Door door)
  {
    thread = new Thread(() -> {

      try
      {
        Thread.sleep(1000);
        door.setDoorState(new OpenedDoorState(door));
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }

    });
    thread.start();

  }

  @Override public void pressButton(Door door)
  {

  }

  @Override public String getState()
  {
    return "Doors opening";
  }
}
