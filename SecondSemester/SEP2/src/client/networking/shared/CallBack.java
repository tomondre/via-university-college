package client.networking.shared;

import java.beans.PropertyChangeEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CallBack extends Remote
{
  void update(PropertyChangeEvent evt) throws RemoteException;
}
