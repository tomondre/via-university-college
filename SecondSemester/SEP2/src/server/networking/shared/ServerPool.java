package server.networking.shared;

import client.networking.shared.CallBack;
import shared.callback.UpdateType;

import java.beans.PropertyChangeEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerPool extends Remote
{
  void registerCallBackClient(CallBack client) throws RemoteException;
}
