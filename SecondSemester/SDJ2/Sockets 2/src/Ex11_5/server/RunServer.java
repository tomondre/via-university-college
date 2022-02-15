package Ex11_5.server;

import java.io.IOException;

public class RunServer
{
  public static void main(String[] args) throws IOException
  {
    SocketServer server = new SocketServer();
    server.start();
  }
}
