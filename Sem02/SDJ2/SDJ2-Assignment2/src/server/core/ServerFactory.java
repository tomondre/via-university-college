package server.core;

import server.networking.SocketServer;

import java.io.IOException;

public class ServerFactory
{
  private SocketServer server;
  private ModelFactory mf;

  public ServerFactory(ModelFactory mf)
  {
    this.mf = mf;
    server = new SocketServer(mf.getServerModel());
  }

  public void start() throws IOException
  {
    server.start();
  }

  public SocketServer getServer()
  {
    return server;
  }
}
