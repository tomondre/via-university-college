package server.networking;

import server.ServerModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private ServerModel model;

  public SocketServer(ServerModel model)
  {
    this.model = model;
  }

  public void start() throws IOException
  {

    try (ServerSocket serverSocket = new ServerSocket(1234))
    {
      while (true)
      {
        Socket socket = serverSocket.accept();
        ServerSocketHandler handler = new ServerSocketHandler(socket, model);
        Thread t = new Thread(handler);
        t.start();
      }
    }
  }
}