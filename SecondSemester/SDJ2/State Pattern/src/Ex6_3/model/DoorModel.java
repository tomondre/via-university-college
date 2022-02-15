package Ex6_3.model;

public interface DoorModel extends PropertyChangeSubject
{
  void pressDoorButton();
  String getState();
}
