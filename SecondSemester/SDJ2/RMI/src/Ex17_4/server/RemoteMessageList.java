package Ex17_4.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMessageList extends Remote
{
  void addMessage(String msg) throws RemoteException;
}
