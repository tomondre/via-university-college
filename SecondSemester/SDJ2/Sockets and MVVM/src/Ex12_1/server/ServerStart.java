package Ex12_1.server;

import Ex12_1.server.model.DataModel;
import Ex12_1.server.model.DataModelManager;
import Ex12_1.server.network.SocketServer;

public class ServerStart
{
  public static void main(String[] args)
  {
    DataModel model = new DataModelManager();
    SocketServer server = new SocketServer(model);
    server.start();
  }
}
