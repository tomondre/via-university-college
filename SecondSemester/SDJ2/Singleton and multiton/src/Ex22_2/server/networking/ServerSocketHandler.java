package Ex22_2.server.networking;

import Ex22_2.server.model.ServerModel;
import Ex22_2.shared.Message;
import Ex22_2.shared.Request;
import Ex22_2.shared.RequestType;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

import static Ex22_2.shared.RequestType.*;

public class ServerSocketHandler implements Runnable, PropertyChangeListener
{
  private Socket socket;
  private ServerModel serverModel;

  private ObjectOutputStream out;
  private ObjectInputStream in;

  public ServerSocketHandler(Socket socket, ServerModel serverModel)
  {
    this.socket = socket;
    this.serverModel = serverModel;
    try
    {
      out = new ObjectOutputStream(socket.getOutputStream());
      in = new ObjectInputStream(socket.getInputStream());
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
        Request receivedRequest = (Request) in.readObject();

        switch (receivedRequest.getRequest())
        {
          case Message:
            serverModel.broadcast(RequestType.Message ,(Message) receivedRequest.getArg());
            out.writeObject(new Request(RequestType.Message, 101));
            break;

          case NumberOfConnectedClients:
            int numberOfConnectedClients = serverModel
                .getNumberOfConnectedClients();
            out.writeObject(new Request(NumberOfConnectedClients,
                numberOfConnectedClients));
            break;

          case NameChange:
            Message message = (Message) receivedRequest.getArg();

            serverModel.setClientName(message.getName(), message.getText());

            out.writeObject(new Request(RequestType.NameChange,
                new Message("", "",
                message.getName() + " has changed name to " + message.getText())));
            break;

          case Listener:
            serverModel.addClient(receivedRequest.getArg().toString());
            serverModel.addPropertyChangeListener(this);
            break;
          case ClientList:
            ArrayList<String> list = serverModel.getClientList();
            out.writeObject(new Request(ClientList, list));
        }
      }
      catch (SocketException | EOFException e)
      {
        serverModel.removePropertyChangeListener(this);
        return;
      }
      catch (IOException | ClassNotFoundException e)
      {
        serverModel.removePropertyChangeListener(this);
        e.printStackTrace();
      }
    }
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    try
    {
      out.writeObject(new Request(RequestType.valueOf(evt.getPropertyName()), evt.getNewValue()));
    }
    catch (SocketException e)
    {
      serverModel.removePropertyChangeListener(this);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
