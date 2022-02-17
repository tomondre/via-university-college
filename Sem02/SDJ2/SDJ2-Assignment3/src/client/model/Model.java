package client.model;

import shared.Message;
import shared.PropertyChangeSubject;
import shared.Request;

import java.util.ArrayList;

public interface Model extends PropertyChangeSubject
{
  void sendMessage(String msg);
  void setName(String name);
  int getNumberOfConnectedClients();
  ArrayList<String> getClientNames();
  void receiveRequest(Request request);
}
