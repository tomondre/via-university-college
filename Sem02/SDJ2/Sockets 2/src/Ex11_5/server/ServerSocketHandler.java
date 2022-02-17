package Ex11_5.server;

import Ex11_5.transferobjects.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private SocketServer server;

  private ObjectOutputStream out;
  private ObjectInputStream in;

  public ServerSocketHandler(Socket socket, SocketServer server)
      throws IOException
  {
    this.socket = socket;
    this.server = server;

    out = new ObjectOutputStream(socket.getOutputStream());
    in = new ObjectInputStream(socket.getInputStream());
  }

  @Override public void run()
  {
    while (true)
    {
      try
      {
        server.notifyMessage((Message) in.readObject());
      }
      catch (IOException | ClassNotFoundException e)
      {
        e.printStackTrace();
      }
    }
  }

  public void sendMessage(Message message) throws IOException
  {
    out.writeObject(message);
  }
}
