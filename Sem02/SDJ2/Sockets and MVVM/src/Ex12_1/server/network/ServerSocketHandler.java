package Ex12_1.server.network;

import Ex12_1.shared.Request;
import Ex12_1.server.model.DataModel;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectInputStream in;
  private ObjectOutputStream out;
  private DataModel model;

  public ServerSocketHandler(Socket socket, DataModel model)
  {
    this.socket = socket;
    this.model = model;

    try
    {
      in = new ObjectInputStream(socket.getInputStream());
      out = new ObjectOutputStream(socket.getOutputStream());
    }
    catch (IOException e)
    {
    }
  }

  @Override public void run()
  {
    while (true)
    {
      try
      {
        Request request = (Request) in.readObject();

        switch (request.getRequestType())
        {
          case "getLastTimeStamp":
            out.writeObject(model.getLastUpdateTimeStamp());
            break;

          case "getNumberOfRequest":
            out.writeObject(model.getNumberOfUpdates());

          case "setTimeStamp":
            model.setTimeStamp((Date) request.getArg());

          case "Listener":
            model.addPropertyChangeListener("UpdateTimeStamp", this::onUpdated);
        }
      }
      catch (IOException | ClassNotFoundException e)
      {
        e.printStackTrace();
      }
    }
  }

  private void onUpdated(PropertyChangeEvent propertyChangeEvent)
  {
    try
    {
      Request request = new Request(propertyChangeEvent.getPropertyName(),
          propertyChangeEvent.getNewValue());
      out.writeUnshared(request);
    }
    catch (IOException e)
    {
    }
  }
}
