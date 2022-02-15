import server.model.MessengerManager;
import server.model.ServerModel;
import server.networking.RMIServer;
import server.networking.Server;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer
{
  public static void main(String[] args)
      throws IOException, AlreadyBoundException
  {

    System.out.println(".....Initializing......");

    ServerModel model = new MessengerManager();

    Server server = new RMIServer(model);

    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", server);

    System.out.println("Server started successfully");
  }
}
