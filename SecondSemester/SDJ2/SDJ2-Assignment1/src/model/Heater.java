package model;

import model.heaterStates.HeaterState;
import model.heaterStates.Power0State;

public class Heater
{
  private HeaterState state = new Power0State();
private final HeatingSystem system;

  public Heater(HeatingSystem system)
  {
    this.system = system;
  }



  public void setState(HeaterState state){
    this.state = state;
    system.firePropertyChange("HeaterChange", -1, -5);
  }

  public int getPower()
  {
    return state.getPower();
  }

  public void turnDown()
  {
    state.turnDown(this);
  }

  public void turnUp(){
    state.turnUp(this);
  }
}
