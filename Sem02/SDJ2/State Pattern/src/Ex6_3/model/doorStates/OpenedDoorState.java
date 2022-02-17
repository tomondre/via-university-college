package Ex6_3.model.doorStates;

import Ex6_3.model.Door;

public class OpenedDoorState implements DoorState
{
  private Thread thread;

  public OpenedDoorState(Door door)
  {
    thread = new Thread(() -> {
      {
        try
        {
          Thread.sleep(5000);
          door.setDoorState(new ClosingDoorState(door));
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    });
    thread.start();
  }

  @Override public void pressButton(Door door)
  {
    thread.interrupt();
    door.setDoorState(new ClosingDoorState(door));
  }

  @Override public String getState()
  {
    return "Doors opened";
  }
}