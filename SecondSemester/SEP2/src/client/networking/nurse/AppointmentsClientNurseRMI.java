package client.networking.nurse;

import server.networking.nurse.AppointmentsServerNurse;
import shared.Appointment;

import javax.print.DocFlavor;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AppointmentsClientNurseRMI implements AppointmentsClientNurse
{
  private AppointmentsServerNurse serverNurse;

  public AppointmentsClientNurseRMI()
  {
    try
    {
      Registry registry = LocateRegistry.getRegistry(1099);
      serverNurse = (AppointmentsServerNurse) registry.lookup("AppointmentServerNurse");
    }
    catch (RemoteException | NotBoundException e)
    {
      throw new RuntimeException("Could not connect to the server, please try again later.");
    }
  }

  @Override public void createAppointment(Appointment appointment)
  {
    try
    {
      serverNurse.createAppointment(appointment);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while creating appointment. Please try again.");
    }
  }

  @Override public void removeAppointment(Appointment appointment)
  {
    try
    {
      serverNurse.removeAppointment(appointment);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while editing appointment. Please try again.");
    }
  }
}
