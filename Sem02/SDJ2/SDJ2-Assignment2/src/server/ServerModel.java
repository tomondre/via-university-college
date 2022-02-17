package server;

import shared.Message;
import shared.PropertyChangeSubject;
import shared.Request;
import shared.RequestType;

import java.util.ArrayList;

public interface ServerModel extends PropertyChangeSubject
{
  void broadcast(RequestType type, Message message);
  int getNumberOfConnectedClients();
  void addClient(String name);
  void setClientName(String oldName, String newName);
  ArrayList<String> getClientList();
}
