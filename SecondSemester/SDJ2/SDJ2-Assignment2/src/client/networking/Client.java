package client.networking;

import shared.Message;
import shared.PropertyChangeSubject;

import java.util.ArrayList;

public interface Client extends PropertyChangeSubject
{
  void sendMessage(Message message);
  int getNumberOfConnectedClients();
  void setName(String oldName, String newName);
  ArrayList<String> getClientNames();
}
