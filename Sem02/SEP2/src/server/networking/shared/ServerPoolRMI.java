package server.networking.shared;

import client.networking.shared.CallBack;
import server.model.shared.ServerPoolModel;
import server.model.shared.ServerPoolModelImpl;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServerPoolRMI implements ServerPool, PropertyChangeListener
{
  private ArrayList<CallBack> clients;
  private ServerPoolModel model;

  public ServerPoolRMI(Registry registry)
      throws AlreadyBoundException, RemoteException
  {
    clients = new ArrayList<>();

    model = ServerPoolModelImpl.getInstance();
    model.addPropertyChangeListener(null, this);

    UnicastRemoteObject.exportObject(this, 0);
    startServer(registry);
  }

  private void startServer(Registry registry)
      throws AlreadyBoundException, RemoteException
  {
    registry.bind("ServerPool", this);
    System.out.println("ServerPool is running");
  }

  @Override public void registerCallBackClient(CallBack client)
  {
    clients.add(client);
  }

  public void update(PropertyChangeEvent evt)
  {
    try
    {
      for (CallBack client : clients)
      {
        client.update(evt);
      }
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    update(evt);
  }
}
