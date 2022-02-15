package client.model.doctor;

import shared.Doctor;
import shared.Nurse;

import java.util.ArrayList;

public interface NursesModelDoctor
{
  ArrayList<Nurse> getAllAvailableNurses();
  void assignNurse(Nurse nurse, Doctor doctor);
  ArrayList<Nurse> getAllNursesAssignedToMe(Doctor doctor);
}
