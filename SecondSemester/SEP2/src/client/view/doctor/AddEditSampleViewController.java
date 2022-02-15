package client.view.doctor;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.shared.SelectionModel;
import client.view.sharted.Alerts;
import client.view.sharted.View;
import client.view.sharted.ViewController;
import client.view_models.doctor.AddEditSampleViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.security.InvalidParameterException;

public class AddEditSampleViewController implements ViewController
{
  @FXML private ComboBox<String> sampleType;
  @FXML private TextArea result;
  @FXML private DatePicker deadline;
  @FXML private ComboBox<String> priority;

  private ViewHandler viewHandler;
  private AddEditSampleViewModel addEditSampleViewModel;

  @FXML public void onSaveButton()
  {
    try
    {
      addEditSampleViewModel.saveChanges();
      Alerts.throwAlert(Alert.AlertType.INFORMATION, "Sample was successfully added/edited");
    }
    catch (InvalidParameterException e)
    {
      Alerts.throwAlert(Alert.AlertType.ERROR, e.getMessage());
    }
  }

  @FXML public void onBackButton()
  {
    if (SelectionModel.getInstance().getLastOpenedView() == View.PATIENTS)
    {
      viewHandler.openView(View.PATIENTS);
    }
    else
    {
      viewHandler.openView(View.DOCTOR_MAIN);
    }
  }

  @FXML public void onClearButton()
  {
    addEditSampleViewModel.clear();
  }

  @Override public void init(ViewModelFactory viewModelFactory,
      ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
    addEditSampleViewModel = (AddEditSampleViewModel) viewModelFactory
        .getViewModel(View.ADD_EDIT_SAMPLE);
    result.textProperty()
        .bindBidirectional(addEditSampleViewModel.resultProperty());
    sampleType.valueProperty()
        .bindBidirectional(addEditSampleViewModel.typeProperty());
    deadline.valueProperty()
        .bindBidirectional(addEditSampleViewModel.deadlineProperty());
    priority.valueProperty()
        .bindBidirectional(addEditSampleViewModel.priorityProperty());

    priority.getItems().setAll("1", "2", "3", "4", "5");
    sampleType.getItems().setAll("blood", "stool", "urine", "DNA");

    addEditSampleViewModel.loadSelectedSample();
  }
}
