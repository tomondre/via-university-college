package Ex6_3.model.doorStates;

import Ex6_3.model.Door;

public class ClosingDoorState implements DoorState
{
  private Thread thread;

  public ClosingDoorState(Door door)
  {
    thread = new Thread(() -> {
      try
      {
        Thread.sleep(3000);
        door.setDoorState(new CloseDoorState());

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
    thread.interrupt();
    door.setDoorState(new OpeningDoorState(door));
  }

  @Override public String getState()
  {
    return "Closing door";
  }
}
