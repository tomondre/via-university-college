package Ex11_4.server;

import Ex11_4.model.Model;
import Ex11_4.model.StringModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  private int id;
  private Model model = new StringModel();
  private ServerSocketHandler handler;

  public void start() throws IOException
  {
    try (ServerSocket serverSocket = new ServerSocket(1234))
    {
      while (true)
      {
        Socket socket = serverSocket.accept();
        handler = new ServerSocketHandler(socket, id, this);
        Thread t = new Thread(handler);
        t.start();
        id++;
      }
    }
  }

  public void action(ServerSocketHandler handler, String message)
      throws IOException
  {
    System.out.println(message);
    handler.message("And hello to you, client number: " + handler.getID());
  }
}
