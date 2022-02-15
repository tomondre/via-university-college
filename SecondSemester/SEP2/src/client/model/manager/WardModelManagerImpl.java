package client.model.manager;

import client.networking.manager.WardClientManager;
import shared.Ward;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Class containing methods the Manager(User) need to manage the hospitals wards
 */
public class WardModelManagerImpl implements WardModelManager
{
  private WardClientManager clientManager;

  /**
   * Constructor where the corresponding client is passed as an argument
   * @param client argument, which will be assigned to the local private field
   */
  public WardModelManagerImpl(Object client)
  {
    clientManager = (WardClientManager) client;
  }

  /**
   * Adds ward to the database through the MVVM layers
   * @param ward the object containing the ward data
   */
  @Override
  public void addWard(Ward ward)
  {
    try
    {
      clientManager.addWard(ward);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while adding ward. Please try again.");
    }
  }

  /**
   * Edits ward from the database through the MVVM layers
   * @param oldWard the old ward
   * @param newWard the new ward
   */
  @Override public void editWard(Ward oldWard, Ward newWard)
  {
    try
    {
      clientManager.editWard(oldWard, newWard);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while editing ward. Please try again.");
    }
  }

  /**
   * Removes the ward from the database through the MVVM layers
   * @param ward the ward to remove
   */
  @Override public void removeWard(Ward ward)
  {
    try
    {
      clientManager.removeWard(ward);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while removing ward. Please try again.");
    }
  }

  /**
   * Gets all the wards stored in the database through the MVVM layers
   * @return ArrayList of Ward objects
   */
  @Override public ArrayList<Ward> getAllWards()
  {
    try
    {
      return clientManager.getAllWards();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while fetching all wards. Please try again.");
    }
  }
}
