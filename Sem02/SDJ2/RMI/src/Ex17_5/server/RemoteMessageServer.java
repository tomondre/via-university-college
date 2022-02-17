package Ex17_5.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteMessageServer implements RemoteMessageList
{
  private ArrayList<String> list;

  public RemoteMessageServer() throws RemoteException
  {
    list = new ArrayList<String>();
    UnicastRemoteObject.exportObject(this, 1099);
  }

  @Override public void addMessage(String msg)
  {
    list.add(msg);
    System.out.println(msg);
  }
}
