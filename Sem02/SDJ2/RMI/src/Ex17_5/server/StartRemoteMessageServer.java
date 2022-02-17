package Ex17_5.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartRemoteMessageServer
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    RemoteMessageServer server = new RemoteMessageServer();

    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", server);

    System.out.println("Server successfully started");
  }
}
