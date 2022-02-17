package model.heaterStates;

import model.Heater;

public class Power3State implements HeaterState
{
  //Configuring waiting time
  private final int timerValue = 20000;

  private final int POWER = 3;
  private final Thread thread;

  public Power3State(Heater heater)
  {
    Runnable runnable = () -> {
      try
      {
        Thread.sleep(timerValue);
        heater.setState(new Power2State());
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    };
    thread = new Thread(runnable);
    thread.setDaemon(true);
    thread.start();
  }

  @Override public void turnUp(Heater heater)
  {

  }

  @Override public void turnDown(Heater heater)
  {
    thread.interrupt();
    heater.setState(new Power2State());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
