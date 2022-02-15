package client.view_models.manager;

import client.model.manager.WardModelManager;
import client.model.shared.CallBackModel;
import client.shared.SelectionModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.CurrentUser;
import shared.Ward;
import shared.callback.UpdateType;

import java.beans.PropertyChangeEvent;
import java.security.InvalidParameterException;
import java.util.List;

public class WardViewModel
{
  private ObservableList<Ward> wards;
  private WardModelManager wardModelManager;

  public WardViewModel(Object wardModelManager, Object callBackModel)
  {
    ((CallBackModel) callBackModel)
        .addPropertyChangeListener(UpdateType.WARD.toString(),
            this::wardUpdated);

    this.wardModelManager = (WardModelManager) wardModelManager;
    wards = FXCollections.observableArrayList();
  }

  private void wardUpdated(PropertyChangeEvent propertyChangeEvent)
  {
    if (CurrentUser.getInstance().isManager())
    {
      loadWards();
    }
  }

  public void removeWard() throws InvalidParameterException
  {
    if (SelectionModel.getInstance().isEmpty())
    {
      throw new InvalidParameterException("Please select ward to remove.");
    }
    wardModelManager.removeWard((Ward) SelectionModel.getInstance().get());
  }

  public void loadWards()
  {
    List<Ward> wardsList = wardModelManager.getAllWards();
    wards.addAll(wardsList);
  }

  public ObservableList<Ward> getWards()
  {
    return wards;
  }
}
