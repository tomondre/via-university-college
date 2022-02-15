package client.networking;

import shared.PropertyChangeSubject;
import shared.Request;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Client extends PropertyChangeSubject
{
  void startClient();
  void sendMessage(Request request);
  void setClientName(String oldName, String newName);
  int getNumberOfConnectedClients();
  ArrayList<String> getClientList();
}
