package client.networking.doctor;

import shared.Doctor;
import shared.Nurse;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface NurseClientDoctor extends Remote
{
  ArrayList<Nurse> getAllAvailableNurses() throws RemoteException;
  void assignNurse(Nurse nurse, Doctor doctor) throws RemoteException;
  ArrayList<Nurse> getAllNursesAssignedToMe(Doctor doctor) throws RemoteException;

}
