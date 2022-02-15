package Ex22_2.server.model;

import Ex22_2.shared.Message;
import Ex22_2.shared.RequestType;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class MessengerManager implements ServerModel
{
  private PropertyChangeSupport support;
  private ArrayList<String> clientUserNameList;

  public MessengerManager()
  {
    clientUserNameList = new ArrayList<String>();
    support = new PropertyChangeSupport(this);
  }

  public synchronized void broadcast(RequestType type, Message message)
  {
    support.firePropertyChange(type.toString(), -1, message);
    if(message != null)
    {
      System.out.println(message.get());
    }
  }

  @Override public synchronized int getNumberOfConnectedClients()
  {
    return support.getPropertyChangeListeners().length;
  }

  @Override public synchronized void addClient(String clientName)
  {
    clientUserNameList.add(clientName);
  }

  @Override public synchronized void setClientName(String oldName, String newName)
  {
    for (int i = 0; i < clientUserNameList.size(); i++)
    {
      if (clientUserNameList.get(i).equals(oldName))
      {
        clientUserNameList.set(i, newName);
        broadcast(RequestType.NameChange, null);
        return;
      }
    }
  }

  @Override public synchronized ArrayList<String> getClientList()
  {
    return clientUserNameList;
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
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
