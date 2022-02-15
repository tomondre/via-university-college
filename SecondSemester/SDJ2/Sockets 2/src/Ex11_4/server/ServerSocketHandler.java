package Ex11_4.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private int id;
  private Server server;

  private ObjectOutputStream out;
  private ObjectInputStream in;

  public ServerSocketHandler(Socket socket, int id, Server server)
      throws IOException
  {
    this.socket = socket;
    this.id = id;
    out = new ObjectOutputStream(socket.getOutputStream());
    in = new ObjectInputStream(socket.getInputStream());
    this.server = server;
  }

  @Override public void run()
  {
    try
    {
      out.writeObject(id);

      while (true)
      {
        server.action(this, (String) in.readObject());
      }
    }
    catch (Exception e)
    {
    }
  }

  public void message(String s) throws IOException
  {
    out.writeObject(s);
  }

  public int getID()
  {
    return id;
  }
}
