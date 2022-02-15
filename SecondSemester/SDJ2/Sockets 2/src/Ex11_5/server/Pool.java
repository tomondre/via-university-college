package Ex11_5.server;

import Ex11_5.transferobjects.Message;

import java.io.IOException;
import java.util.ArrayList;

public class Pool
{
  private ArrayList<ServerSocketHandler> handlers;

  public Pool()
  {
    handlers = new ArrayList<ServerSocketHandler>();
  }

  public synchronized void addConn(ServerSocketHandler handler)
  {
    handlers.add(handler);
  }

  public synchronized void broadcast(Message message) throws IOException
  {
    for (ServerSocketHandler handler : handlers)
    {
      handler.sendMessage(message);
    }
  }
}
