package Ex12_1.server.network;

import Ex12_1.server.model.DataModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private DataModel model;

  public SocketServer(DataModel model)
  {
    this.model = model;
  }

  public void start()
  {
    try (ServerSocket serverSocket = new ServerSocket(1234))
    {
      while (true)
      {
        Socket socket = serverSocket.accept();

        ServerSocketHandler serverHandler = new ServerSocketHandler(socket, model);
        Thread thread = new Thread(serverHandler);
        thread.start();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
