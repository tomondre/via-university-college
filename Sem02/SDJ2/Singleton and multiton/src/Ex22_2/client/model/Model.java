package Ex22_2.client.model;

import Ex22_2.shared.PropertyChangeSubject;

import java.util.ArrayList;

public interface Model extends PropertyChangeSubject
{
  void sendMessage(String msg);
  void setName(String name);
  int getNumberOfConnectedClients();
  ArrayList<String> getClientNames();
}
