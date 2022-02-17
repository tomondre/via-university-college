package Ex11_4.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocketHandler implements Runnable
{
  private Socket socket;
  private int id;
  private Client client;

  private ObjectOutputStream out;
  private ObjectInputStream in;

  public ClientSocketHandler(Socket socket, Client client)
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
      e.printStackTrace();
    }
  }

  public void run()
  {
    try
    {
      client.setID((int) in.readObject());

      while (true)
      {
        client.message((String) in.readObject());
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  public void sendMessage(String msg) throws IOException
  {
    out.writeObject(msg);
  }
}
