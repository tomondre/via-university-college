package client.model;

import client.networking.Client;
import shared.Message;
import shared.RequestType;

import javax.swing.event.SwingPropertyChangeSupport;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ChatModel implements Model, PropertyChangeListener
{
  private PropertyChangeSupport support = new SwingPropertyChangeSupport(this);

  private Client client;
  private String name;

  public ChatModel(Client client)
  {
    name = RequestType.DefaultName.toString();
    this.client = client;
    client.addPropertyChangeListener(this);
  }

  @Override public void sendMessage(String msg)
  {
    client.sendMessage(new Message(
        LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), name,
        msg));
  }

  @Override public void setName(String name)
  {
    if (this.name.equals(RequestType.DefaultName.toString()))
    {
      client.setName(this.name, name);
      this.name = name;
      sendMessage(" has joined the chat");
    }
    else
    {
      client.setName(this.name, name);
      sendMessage(" have changed the name to: " + name);
      this.name = name;
    }
  }

  @Override public int getNumberOfConnectedClients()
  {
    return client.getNumberOfConnectedClients();
  }

  @Override public ArrayList<String> getClientNames()
  {
    return client.getClientNames();
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
