package Ex3_3.observers;

import Ex3_3.subject.WaitingRoom;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Patient implements PropertyChangeListener
{
  private int ticketNumber;
  private WaitingRoom waitingRoom;

  public Patient(int ticketNumber, WaitingRoom waitingRoom)
  {
    this.ticketNumber = ticketNumber;
    this.waitingRoom = waitingRoom;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    System.out.println("patient " + ticketNumber + " looks up");
    if ((int) (evt.getNewValue()) == ticketNumber)
    {
      System.out
          .println("Patient " + ticketNumber + " goes to the doctors room");
      waitingRoom.removePropertyChangeListener(this);
    }
    else
    {
      System.out.println("Patient " + ticketNumber + " looks back at phone");
    }
  }
}
