package server.model;

import client.model.ChatModel;
import shared.Message;
import shared.PropertyChangeSubject;
import shared.Request;
import shared.RequestType;

import java.beans.PropertyChangeSupport;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServerModel extends PropertyChangeSubject
{
  void broadcast(Request request) throws RemoteException;
  int getNumberOfConnectedClients() throws RemoteException;
  void addClient(String name) throws RemoteException;
  void setClientName(String oldName, String newName) throws RemoteException;
  ArrayList<String> getClientList() throws RemoteException;
  void sendMessage(Request request) throws RemoteException;
}
