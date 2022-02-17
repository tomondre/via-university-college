package Ex11_5.server;

import Ex11_5.transferobjects.Message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{

  private Pool pool = new Pool();

  public void start() throws IOException
  {

    try (ServerSocket serverSocket = new ServerSocket(1234))
    {
      while (true)
      {
        Socket socket = serverSocket.accept();
        ServerSocketHandler handler = new ServerSocketHandler(socket, this);
        pool.addConn(handler);
        Thread t = new Thread(handler);
        t.start();
      }
    }
  }

  public void notifyMessage(Message message) throws IOException
  {
    System.out.println(message.get());
    pool.broadcast(message);
  }
}
