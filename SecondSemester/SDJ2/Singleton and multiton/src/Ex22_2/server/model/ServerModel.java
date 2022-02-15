package Ex22_2.server.model;

import Ex22_2.shared.Message;
import Ex22_2.shared.PropertyChangeSubject;
import Ex22_2.shared.RequestType;

import java.util.ArrayList;

public interface ServerModel extends PropertyChangeSubject
{
  void broadcast(RequestType type, Message message);
  int getNumberOfConnectedClients();
  void addClient(String name);
  void setClientName(String oldName, String newName);
  ArrayList<String> getClientList();
}
