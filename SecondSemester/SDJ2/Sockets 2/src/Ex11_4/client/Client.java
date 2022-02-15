package Ex11_4.client;

import java.io.IOException;
import java.net.Socket;

public class Client
{
  private int id;
  private ClientSocketHandler handler;

  public void start() throws IOException
  {
    try
    {
      Socket socket = new Socket("localhost", 1234);
      handler = new ClientSocketHandler(socket, this);
      new Thread(handler).start();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    for (int i = 0; i < 3; i++)
    {
      handler.sendMessage("Hello from client number: " + id);
    }
  }

  public void message(String o)
  {
    System.out.println(o);
  }

  public void setID(int id)
  {
    this.id = id;
  }
}
