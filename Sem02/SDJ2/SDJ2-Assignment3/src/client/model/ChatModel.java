package client.model;

import client.networking.Client;
import shared.Message;
import shared.Request;
import shared.RequestType;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ChatModel implements Model, PropertyChangeListener
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  private String name;
  private Client client;

  public ChatModel(Client client)
  {
    this.client = client;
    client.addPropertyChangeListener(this);
    name = RequestType.DefaultName.toString();
  }

  @Override public void sendMessage(String msg)
  {
    client.sendMessage(new Request(RequestType.Message, new Message(
        LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), name,
        msg)));

  }

  @Override public void setName(String name)
  {
    client.setClientName(this.name, name);
    this.name = name;
  }

  @Override public int getNumberOfConnectedClients()
  {
    return client.getNumberOfConnectedClients();
  }

  @Override public ArrayList<String> getClientNames()
  {
    return client.getClientList();
  }

  @Override public void receiveRequest(Request request)
  {
    support.firePropertyChange("", -1, request);
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

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
  }
}
