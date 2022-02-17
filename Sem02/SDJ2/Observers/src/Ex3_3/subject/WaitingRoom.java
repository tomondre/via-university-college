package Ex3_3.subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WaitingRoom implements PropertyChangeSubject
{
  PropertyChangeSupport propertyChangeSupport;

  private int counter;

  public WaitingRoom()
  {
    counter = 0;
    propertyChangeSupport = new PropertyChangeSupport(this);
  }

  public void start()
  {
    while (propertyChangeSupport.getPropertyChangeListeners().length!=0)
    {
      counter++;
      try
      {
        Thread.sleep(3000);
      }
      catch (InterruptedException e)
      {
      }
      System.out.println("\n DING DONG YOUR OPINION IS WRONG");
      numberChanged();
    }
  }



  public void numberChanged()
  {
    propertyChangeSupport
        .firePropertyChange("DoctorCall", counter - 1, counter);
  }

  public void addPropertyChangeListener(PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(listener);
    listener.propertyChange(
        new PropertyChangeEvent(this, "DoctorCall", counter - 1, counter));
  }

  public void removePropertyChangeListener(PropertyChangeListener listener)
  {
    propertyChangeSupport.removePropertyChangeListener(listener);
  }
}
