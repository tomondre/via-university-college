package Ex3_3;

import Ex3_3.observers.Patient;
import Ex3_3.subject.WaitingRoom;

public class Main
{
  public static void main(String[] args)
  {
    WaitingRoom room = new WaitingRoom();
    Patient[]  patients = new Patient[3];

    for (int i = 0; i < patients.length; i++)
    {
      patients[i] = new Patient(i+1, room);
      room.addPropertyChangeListener(patients[i]);
    }
    room.start();

  }
}
