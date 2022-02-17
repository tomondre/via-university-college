package client.view_models.manager;

import client.model.manager.WardModelManager;
import client.shared.SelectionModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Ward;

import java.security.InvalidParameterException;

public class AddEditWardViewModel
{
  private ObservableList<Ward> wards;
  private StringProperty wardNameProperty;
  private StringProperty roomNumberProperty;

  private WardModelManager wardModelManager;

  public AddEditWardViewModel(Object wardModelManager)
  {
    this.wardModelManager = (WardModelManager) wardModelManager;
    wards = FXCollections.observableArrayList();
    wardNameProperty = new SimpleStringProperty();
    roomNumberProperty = new SimpleStringProperty();
  }

  public void saveChanges() throws InvalidParameterException
  {
    if(validateInput())
    {
      throw new InvalidParameterException("Please add ward name and room number.");
    }
    String wardName = wardNameProperty.get();
    int roomNumber = Integer.parseInt(roomNumberProperty.get());
    Ward toAdd = new Ward(wardName, roomNumber);
    wardModelManager.addWard(toAdd);
  }

  private boolean validateInput()
  {
    return wardNameProperty.get() == null || wardNameProperty.get().isBlank() || roomNumberProperty.get() == null || roomNumberProperty.get().isBlank();
  }

  private void fillFields(Ward ward)
  {
    wardNameProperty.set(ward.getWardName());
    roomNumberProperty.set(String.valueOf(ward.getRoomNumber()));
  }

  public void fillWards()
  {
    wards.addAll(wardModelManager.getAllWards());
    if (!SelectionModel.getInstance().isEmpty())
    {
      fillFields((Ward) SelectionModel.getInstance().get());
    }
  }

  public void clear()
  {
    wardNameProperty.set("");
    roomNumberProperty.set("");
  }

  public ObservableList<Ward> getAllWards()
  {
    return wards;
  }

  public StringProperty wardNameProperty()
  {
    return wardNameProperty;
  }

  public StringProperty roomNumberProperty()
  {
    return roomNumberProperty;
  }
}
