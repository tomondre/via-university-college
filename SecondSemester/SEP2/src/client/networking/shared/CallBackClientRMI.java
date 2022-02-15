package client.networking.shared;

import server.networking.shared.ServerPool;
import shared.util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CallBackClientRMI
    implements CallBack, Serializable, PropertyChangeSubject
{
  private PropertyChangeSupport support;
  private ServerPool pool;

  public CallBackClientRMI()
  {
    try
    {
      Registry registry = LocateRegistry.getRegistry(1099);
      pool = (ServerPool) registry.lookup("ServerPool");
      UnicastRemoteObject.exportObject(this, 0);
    }
    catch (RemoteException | NotBoundException e)
    {
      throw new RuntimeException(
          "Could not connect to the server, please try again later.");
    }
    try
    {
      this.support = new PropertyChangeSupport(this);
      pool.registerCallBackClient(this);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(
          "Error while registering client to server, pleaser try again.");
    }
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if (name == null)
    {
      this.support.addPropertyChangeListener(listener);
    }
    else
    {
      support.addPropertyChangeListener(name, listener);
    }
  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }

  @Override public synchronized void update(PropertyChangeEvent evt)
  {
    this.support.firePropertyChange(evt);
  }
}
