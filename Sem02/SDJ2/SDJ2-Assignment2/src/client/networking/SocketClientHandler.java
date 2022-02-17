package client.networking;

import shared.Message;
import shared.PropertyChangeSubject;
import shared.Request;
import shared.RequestType;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import static shared.RequestType.*;

public class SocketClientHandler implements Runnable, PropertyChangeSubject
{

  private PropertyChangeSupport support;
  private ObjectOutputStream out;
  private ObjectInputStream in;

  private Socket socket;

  public SocketClientHandler(Socket socket)
  {
    this.socket = socket;
    support = new PropertyChangeSupport(this);
  }

  @Override public void run()
  {
    try
    {
      out = new ObjectOutputStream(socket.getOutputStream());
      in = new ObjectInputStream(socket.getInputStream());

      out.writeObject(new Request(Listener, RequestType.DefaultName));

      while (true)
      {
        Request request = (Request) in.readObject();

        support.firePropertyChange("", -1, request);
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
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

  public int getNumberOfConnectedClients()
  {
    try
    {
      int answer = (int) request(NumberOfConnectedClients, null).getArg();
      return answer;
    }
    catch (IOException | ClassNotFoundException e)
    {
    }
    return -1;
  }

  public void sendMessage(Message message)
  {
    try
    {
      request(Message, message);
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  public void setName(String oldName, String newName)
  {
    try
    {
      Message message = new Message(null, oldName, newName);
      request(NameChange, message);
    }
    catch (IOException | ClassNotFoundException ignored)
    {
      System.out.println("error");
    }
  }

  private Request request(RequestType type, Object arg)
      throws IOException, ClassNotFoundException
  {
    Socket socket = new Socket("localhost", 1234);
    ObjectOutputStream outToServer = new ObjectOutputStream(
        socket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(
        socket.getInputStream());
    outToServer.writeObject(new Request(type, arg));
    return (Request) inFromServer.readObject();
  }

  public ArrayList<String> getClientNames()
  {
    try
    {
      return (ArrayList<String>) (request(ClientList, null).getArg());
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
