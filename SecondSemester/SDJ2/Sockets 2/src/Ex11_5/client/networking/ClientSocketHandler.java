package Ex11_5.client.networking;

import Ex11_5.transferobjects.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocketHandler implements Runnable
{
  private SocketClient client;
  private Socket socket;

  private ObjectInputStream in;
  private ObjectOutputStream out;

  public ClientSocketHandler(Socket socket, SocketClient client)
  {
    this.socket = socket;
    this.client = client;
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
    try
    {

      while (true)
      {
        client.receiveMessage((Message) in.readObject());
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  public void sendMessage(Message message)
  {
    try
    {
      out.writeObject(message);
    }
    catch (IOException e)
    {
      System.out.println("Message send failed");
      e.printStackTrace();
    }
  }
}
