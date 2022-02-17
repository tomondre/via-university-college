package client.networking.doctor;

import server.networking.doctor.NursesServerDoctor;
import shared.Doctor;
import shared.Nurse;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class NurseClientDoctorRMI implements NurseClientDoctor
{
  private NursesServerDoctor serverDoctor;

  public NurseClientDoctorRMI()
  {
    try
    {
      Registry registry = LocateRegistry.getRegistry(1099);
      serverDoctor = (NursesServerDoctor) registry.lookup("NursesServerDoctor");
    }
    catch (RemoteException | NotBoundException e)
    {
      throw new RuntimeException("Could not connect to the server, please try again later.");
    }
  }

  @Override public ArrayList<Nurse> getAllAvailableNurses()
  {
    try
    {
      return serverDoctor.getAllAvailableNurses();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while fetching all nurses. Please try again.");
    }
  }

  @Override public void assignNurse(Nurse nurse, Doctor doctor)
  {
    try
    {
      serverDoctor.assignNurse(nurse, doctor);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while assigning nurse. Please try again.");
    }
  }

  @Override public ArrayList<Nurse> getAllNursesAssignedToMe(Doctor doctor)
  {
    try
    {
      return serverDoctor.getAllNursesAssignedToMe(doctor);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while fetching all nurses. Please try again.");
    }
  }
}
