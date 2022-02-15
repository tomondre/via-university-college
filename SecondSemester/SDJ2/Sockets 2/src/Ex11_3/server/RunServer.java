package Ex11_3.server;

import java.io.IOException;

public class RunServer
{

  public static void main(String[] args) throws IOException
  {
    SocketServer server = new SocketServer();
    server.start();
  }

}
