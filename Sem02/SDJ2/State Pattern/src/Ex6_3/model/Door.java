package Ex6_3.model;

import Ex6_3.model.doorStates.CloseDoorState;
import Ex6_3.model.doorStates.DoorState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Door implements DoorModel
{
  private DoorState currentState = new CloseDoorState();
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public void pressDoorButton()
  {
    currentState.pressButton(this);
  }

  public void setDoorState(DoorState state)
  {
    currentState = state;
    System.out.println(getState());
    statusChanged();
  }

  public String getState()
  {
    return currentState.getState();
  }

  public void statusChanged()
  {
    support.firePropertyChange("change", -1,0);
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }
}
