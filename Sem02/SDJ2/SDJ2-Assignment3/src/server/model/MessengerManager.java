package server.model;

import client.model.ChatModel;
import shared.Message;
import shared.Request;
import shared.RequestType;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class MessengerManager implements ServerModel
{
  private PropertyChangeSupport support;
  private ArrayList<String> clientUserNameList;

  public MessengerManager() throws RemoteException
  {
    clientUserNameList = new ArrayList<String>();
    support = new PropertyChangeSupport(this);
  }

  @Override public void sendMessage(Request request)
  {
    System.out.println((((Message) request.getArg())).get());
    broadcast(request);
  }

  public void broadcast(Request request)
  {
    support.firePropertyChange(RequestType.Message.toString(), -1, request);
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void addClient(String clientName)
  {
    clientUserNameList.add(clientName);
  }

  @Override public int getNumberOfConnectedClients()
  {
    return support.getPropertyChangeListeners().length;
  }

  @Override public void setClientName(String oldName,
      String newName)
  {
    for (int i = 0; i < clientUserNameList.size(); i++)
    {
      if (clientUserNameList.get(i).equals(oldName))
      {
        clientUserNameList.set(i, newName);
        System.out.println(newName);

        broadcast(new Request(RequestType.NameChange,
            new Message("", oldName, " has changed name to: " + newName)));
        return;
      }
    }
  }

  @Override public ArrayList<String> getClientList()
  {
    for (String s : clientUserNameList)
    {
      System.out.println(s);
    }
    return clientUserNameList;
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}
