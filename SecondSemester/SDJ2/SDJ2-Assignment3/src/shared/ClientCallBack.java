package shared;

import shared.PropertyChangeSubject;
import shared.Request;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallBack extends Remote
{
  void receiveMessage(Request request) throws RemoteException;
}
