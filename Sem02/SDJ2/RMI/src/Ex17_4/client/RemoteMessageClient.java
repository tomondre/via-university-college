package Ex17_4.client;

import Ex17_4.server.RemoteMessageList;
import Ex17_4.server.RemoteMessageServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteMessageClient
{
  private RemoteMessageList server;

  public RemoteMessageClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    this.server = (RemoteMessageList) registry.lookup("Server");
  }

  public void sendMessage(String msg) throws RemoteException
  {
    server.addMessage(msg);
  }
}
