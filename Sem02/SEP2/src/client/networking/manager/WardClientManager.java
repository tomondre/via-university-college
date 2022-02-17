package client.networking.manager;

import shared.Ward;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface WardClientManager extends Remote
{
  void addWard(Ward ward) throws RemoteException;
  void removeWard(Ward ward) throws RemoteException;
  ArrayList<Ward> getAllWards() throws RemoteException;

  void editWard(Ward oldWard, Ward newWard) throws RemoteException;
}
