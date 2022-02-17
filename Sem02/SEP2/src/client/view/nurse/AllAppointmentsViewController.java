package client.view.nurse;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.sharted.Alerts;
import client.view.sharted.View;
import client.view.sharted.ViewController;
import client.view_models.nurse.AllAppointmentsViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.Appointment;

import java.security.InvalidParameterException;
import java.sql.Timestamp;

public class AllAppointmentsViewController implements ViewController
{
  @FXML private TableView<Appointment> appointmentsTableView;
  @FXML private TableColumn<Appointment, Timestamp> startDateAppColumn;
  @FXML private TableColumn<Appointment, Timestamp> endDateAppColumn;
  @FXML private TableColumn<Appointment, Long> patientSSNAppColumn;
  @FXML private TableColumn<Appointment, Long> doctorSSNAppColumn;


  private ViewHandler viewHandler;
  private AllAppointmentsViewModel viewModel;
  private Appointment selectedAppointment;

  @FXML public void onRemoveButton()
  {
    selectedAppointment = appointmentsTableView.getSelectionModel().selectedItemProperty().getValue();
    try
    {
      viewModel.removeAnAppointment(selectedAppointment);
      Alerts.throwAlert(Alert.AlertType.INFORMATION, "Appointment was successfully removed.");
    }
    catch (InvalidParameterException e)
    {
      Alerts.throwAlert(Alert.AlertType.ERROR, e.getMessage());
    }
  }

  @FXML public void onBackButton()
  {
    if (client.shared.SelectionModel.getInstance().getLastOpenedView() == null)
    {
      viewHandler.openView(View.NURSE_MAIN);
    }
    else
    {
      client.shared.SelectionModel.getInstance().setLastOpenedView(null);
      viewHandler.openView(View.MAKE_APPOINTMENT);
    }
  }

  @Override
  public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
    this.viewModel = (AllAppointmentsViewModel) viewModelFactory.getViewModel(View.ALL_APPOINTMENTS);
    viewModel.loadAppointments();
    appointmentsTableView.setItems(viewModel.getAllAppointments());
    startDateAppColumn.setCellValueFactory(new PropertyValueFactory<>("from"));
    endDateAppColumn.setCellValueFactory(new PropertyValueFactory<>("to"));
    patientSSNAppColumn.setCellValueFactory(new PropertyValueFactory<>("patientSSN"));
    doctorSSNAppColumn.setCellValueFactory(new PropertyValueFactory<>("doctorSSN"));

  }
}
