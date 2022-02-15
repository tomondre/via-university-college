package client.model;

import shared.PropertyChangeSubject;

import java.util.ArrayList;

public interface Model extends PropertyChangeSubject
{
  void sendMessage(String msg);
  void setName(String name);
  int getNumberOfConnectedClients();
  ArrayList<String> getClientNames();
}
