package client.networking.manager;

import server.networking.manager.EmployeeServerManager;
import shared.Doctor;
import shared.Nurse;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class EmployeeClientRMI implements EmployeeClientManager
{
  private EmployeeServerManager serverManager;

  public EmployeeClientRMI()
  {
    try
    {
      Registry registry = LocateRegistry.getRegistry(1099);
      serverManager = (EmployeeServerManager) registry.lookup("EmployeeServerManager");
    }
    catch (RemoteException | NotBoundException e)
    {
     throw new RuntimeException("Could not connect to the server, please try again later.");
    }
  }

  @Override public String addDoctor(Doctor doctor)
  {
    try
    {
      return serverManager.addDoctor(doctor);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while adding doctor to the system. Please try again.");
    }
  }

  @Override public String addNurse(Nurse nurse)
  {
    try
    {
      return serverManager.addNurse(nurse);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while adding nurse to the system. Please try again.");
    }
  }

  @Override public String editDoctor(Doctor doctor)
  {
    try
    {
      return serverManager.editDoctor(doctor);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while editing doctor to the system. Please try again.");
    }
  }

  @Override public String editNurse(Nurse nurse)
  {
    try
    {
      return serverManager.editNurse(nurse);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while editing nurse to the system. Please try again.");
    }
  }

  @Override public String removeDoctor(Doctor doctor)
  {
    try
    {
      return serverManager.removeDoctor(doctor);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while removing doctor from the system. Please try again.");
    }
  }

  @Override public String removeNurse(Nurse nurse)
  {
    try
    {
      return serverManager.removeNurse(nurse);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while removing nurse from the system. Please try again.");
    }
  }
}
