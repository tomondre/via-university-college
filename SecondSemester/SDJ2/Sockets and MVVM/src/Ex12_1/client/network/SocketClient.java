package Ex12_1.client.network;

import Ex12_1.shared.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

public class SocketClient implements Client
{

  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  private Socket socket;
  private ObjectOutputStream out;
  private ObjectInputStream in;


  @Override public String getLastUpdateTimeStamp()
  {
    try
    {
      Request request = new Request("getLastUpdateTimeStamp", null);
      out.writeObject(request);
      return (String) in.readObject();
    }
    catch (IOException | ClassNotFoundException e)
    {
    }
    return null;
  }

  @Override public int getNumberOfUpdates()
  {
    try
    {
      Request request = new Request("getNumberOfRequest", null);
      out.writeObject(request);
      return (int) in.readObject();
    }
    catch (IOException | ClassNotFoundException e)
    {
    }
    return -1;
  }

  @Override public void setTimeStamp(Date timeStamp)
  {
    try
    {
      Request request = new Request("setTimeStamp", timeStamp);
      out.writeObject(request);
    }
    catch (IOException e)
    {
    }
  }

  @Override public void startClient()
  {
    try
    {
      socket = new Socket("localhost", 1234);
      in = new ObjectInputStream(socket.getInputStream());
      out = new ObjectOutputStream(socket.getOutputStream());

      Socket lambdaSocket = new Socket("localhost", 1234);
      ObjectOutputStream lambdaOut = new ObjectOutputStream(
          lambdaSocket.getOutputStream());
      ObjectInputStream lambdaIn = new ObjectInputStream(
          lambdaSocket.getInputStream());

      Thread thread = new Thread(() -> listenToServer(lambdaOut, lambdaIn));
      thread.start();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  public void listenToServer(ObjectOutputStream outToServer,
      ObjectInputStream inFromServer)
  {
    try
    {
      outToServer.writeObject(new Request("Listener", null));
      while (true)
      {
        Request request = (Request) inFromServer.readObject();
        support.firePropertyChange(request.getRequestType(), null,
            request.getArg());
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}
