package client.networking;

import javafx.application.Platform;
import shared.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class SocketClient implements Client, PropertyChangeListener
{
  private PropertyChangeSupport support;
  private SocketClientHandler handler;

  public SocketClient()
  {
    support = new PropertyChangeSupport(this);
    try
    {
      Socket socket = new Socket("localhost", 1234);
      handler = new SocketClientHandler(socket);
      handler.addPropertyChangeListener(this);
      Thread socketThread = new Thread(handler);
      socketThread.setDaemon(true);
      socketThread.start();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void sendMessage(Message message)
  {
    handler.sendMessage(message);
  }

  public int getNumberOfConnectedClients()
  {
    return handler.getNumberOfConnectedClients();
  }

  @Override public void setName(String oldName, String newName)
  {
    handler.setName(oldName, newName);
  }

  @Override public ArrayList<String> getClientNames()
  {
    return handler.getClientNames();
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
    Platform.runLater(() -> {
      support.firePropertyChange(evt);
    });
  }
}