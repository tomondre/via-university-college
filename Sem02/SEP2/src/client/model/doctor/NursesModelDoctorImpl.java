package client.model.doctor;

import client.networking.doctor.NurseClientDoctor;
import shared.Doctor;
import shared.Nurse;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * The class responsible for the functions of the Doctor(User) for managing the nurse
 */
public class NursesModelDoctorImpl implements NursesModelDoctor
{
  private NurseClientDoctor clientDoctor;

  /**
   * Constructor where the corresponding client is passed as an argument
   * @param client argument, which will be assigned to the local private field
   */
  public NursesModelDoctorImpl(Object client)
  {
    clientDoctor = (NurseClientDoctor) client;
  }

  /**
   * Gets all the available nurses from the database through the MVVM layers
   * @return ArrayList of Nurse objects
   */
  @Override public ArrayList<Nurse> getAllAvailableNurses()
  {
    try
    {
      return clientDoctor.getAllAvailableNurses();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while fetching all nurses. Please try again.");
    }
  }

  /**
   * Assigning a Nurse to the Current user in the database through the MVVM layers
   * @param nurse the Nurse object that has to be assigned
   * @param doctor the Current user Doctor object to which the nurse has to be assigned
   */
  @Override public void assignNurse(Nurse nurse, Doctor doctor)
  {
    try
    {
      clientDoctor.assignNurse(nurse, doctor);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while assigning nurse. Please try again.");
    }
  }

  /**
   * Gets from the database the list of all the nurses assigned to the Current user.
   * @param doctor the Current user Doctor object containing the SSN for fetching the data from the database
   * @return ArrayList of Nurse object specifically assigned to the Current user object
   */
  @Override public ArrayList<Nurse> getAllNursesAssignedToMe(Doctor doctor)
  {
    try
    {
      return clientDoctor.getAllNursesAssignedToMe(doctor);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Error while fetching all nurses. Please try again.");
    }
  }
}
