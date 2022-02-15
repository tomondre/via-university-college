package client.view.doctor;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.shared.SelectionModel;
import client.view.sharted.Alerts;
import client.view.sharted.View;
import client.view.sharted.ViewController;
import client.view_models.doctor.PatientsSampleViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.Sample;

import java.security.InvalidParameterException;
import java.sql.Date;

public class PatientsSampleViewController implements ViewController
{
  public Button addButton;
  @FXML private TableView<Sample> sampleTable;
  @FXML private TableColumn<String, Sample> sampleType;
  @FXML private TableColumn<Date, Sample> sampleDeadline;
  @FXML private TableColumn<Integer, Sample> samplePriority;
  @FXML private TableColumn<String, Sample> result;

  private ViewHandler viewHandler;

  private PatientsSampleViewModel viewModel;

  @FXML public void onEditSampleButton()
  {
    SelectionModel.getInstance()
        .set(sampleTable.getSelectionModel().getSelectedItem());
    try
    {
      viewModel.editSample();
      viewHandler.openView(View.ADD_EDIT_SAMPLE);
    }
    catch (InvalidParameterException e)
    {
      Alerts.throwAlert(Alert.AlertType.ERROR, e.getMessage());
    }
  }

  @FXML public void onAddButton()
  {
    viewModel.setPatientToAdd();
    viewHandler.openView(View.ADD_EDIT_SAMPLE);
  }

  @FXML public void onBackButton()
  {
    if (SelectionModel.getInstance().getLastOpenedView() == View.DOCTOR_MAIN)
    {
      viewHandler.openView(View.DOCTOR_MAIN);
    }
    else
    {
      viewHandler.openView(View.PATIENTS);
    }
  }

  @Override public void init(ViewModelFactory viewModelFactory,
      ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
    viewModel = (PatientsSampleViewModel) viewModelFactory
        .getViewModel(View.PATIENTS_SAMPLE);
    sampleTable.setItems(viewModel.getSamples());
    sampleType.setCellValueFactory(new PropertyValueFactory<>("type"));
    sampleDeadline.setCellValueFactory(new PropertyValueFactory<>("deadline"));
    samplePriority.setCellValueFactory(new PropertyValueFactory<>("priority"));
    result.setCellValueFactory(new PropertyValueFactory<>("result"));

    viewModel.loadSelectedPatientData();

    addButton.setVisible(
        SelectionModel.getInstance().getLastOpenedView() != View.DOCTOR_MAIN);
  }
}
