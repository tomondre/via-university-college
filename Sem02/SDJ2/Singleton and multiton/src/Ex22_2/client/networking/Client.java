package Ex22_2.client.networking;

import Ex22_2.shared.Message;
import Ex22_2.shared.PropertyChangeSubject;

import java.util.ArrayList;

public interface Client extends PropertyChangeSubject
{
  void sendMessage(Message message);
  int getNumberOfConnectedClients();
  void setName(String oldName, String newName);
  ArrayList<String> getClientNames();
}
