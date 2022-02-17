package client.view_models.doctor;

import client.model.doctor.NursesModelDoctor;
import client.model.shared.CallBackModel;
import client.shared.SelectionModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.CurrentUser;
import shared.Doctor;
import shared.Nurse;
import shared.callback.UpdateType;

import java.beans.PropertyChangeEvent;
import java.security.InvalidParameterException;

public class AssignNurseViewModel
{
  private ObservableList<Nurse> availableNurses;
  private ObservableList<Nurse> assignedNurses;

  private NursesModelDoctor nursesModelDoctor;
  private CallBackModel callBackModel;

  public AssignNurseViewModel(Object nursesModelDoctor, Object callBack)
  {
    this.callBackModel = (CallBackModel) callBack;
    callBackModel.addPropertyChangeListener(UpdateType.NURSE.toString(),
        this::updateNurseList);
    this.nursesModelDoctor = (NursesModelDoctor) nursesModelDoctor;
    availableNurses = FXCollections.observableArrayList();
    assignedNurses = FXCollections.observableArrayList();
  }

  private void updateNurseList(PropertyChangeEvent propertyChangeEvent)
  {
    if (CurrentUser.getInstance().isDoctor())
    {
      loadTables();
    }
  }

  public ObservableList<Nurse> getAvailableNurses()
  {
    return availableNurses;
  }

  public ObservableList<Nurse> getAssignedNurses()
  {
    return assignedNurses;
  }

  public void assignNurse() throws InvalidParameterException
  {
    Nurse nurse = (Nurse) SelectionModel.getInstance().get();
    if (nurse == null)
    {
      throw new InvalidParameterException("Please select nurse to assign.");
    }
    Doctor currentDoctorUser = (Doctor) CurrentUser.getInstance()
        .getCurrentUser();

    nursesModelDoctor.assignNurse(nurse, currentDoctorUser);
  }

  public void loadTables()
  {
    availableNurses.setAll(nursesModelDoctor.getAllAvailableNurses());
    assignedNurses.setAll(nursesModelDoctor.getAllNursesAssignedToMe(
        (Doctor) CurrentUser.getInstance().getCurrentUser()));
  }

}
