package client.view.nurse;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.sharted.Alerts;
import client.view.sharted.View;
import client.view.sharted.ViewController;
import client.view_models.nurse.MakeAppointmentViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.Doctor;
import shared.Patient;
import client.shared.SelectionModel;

public class MakeAppointmentViewController implements ViewController
{
  @FXML private TableView<Doctor> doctorsTableViewMakeAppointment;
  @FXML private TableColumn<Doctor, String> firstNameColumnDoctors;
  @FXML private TableColumn<Doctor, String> lNameColumnDoctors;
  @FXML private TableColumn<Doctor, Long> ssnColumnDoctors;
  @FXML private TextField timeMakeAppointmentTxtField;
  @FXML private DatePicker makeAppointmentDateField;
  @FXML private TableView<Patient> patientsTableViewMakeAppointment;
  @FXML private TableColumn<Patient, String> fNameColumnPatients;
  @FXML private TableColumn<Patient, String> lNameColumnPatients;
  @FXML private TableColumn<Patient, Long> ssnColumnPatients;


  private ViewHandler viewHandler;
  private MakeAppointmentViewModel viewModel;
  private Patient patient;
  private Doctor doctor;

  @FXML public void onSaveButton()
  {
    patient = patientsTableViewMakeAppointment.getSelectionModel().getSelectedItem();
    doctor = doctorsTableViewMakeAppointment.getSelectionModel().getSelectedItem();
    try
    {
      viewModel.createAppointment(patient, doctor);
      Alerts.throwAlert(Alert.AlertType.INFORMATION, "Appointment successfully created");
    }
    catch (Exception e)
    {
      Alerts.throwAlert(Alert.AlertType.ERROR, e.getMessage());
    }
  }

  @FXML public void onBackButton()
  {
    viewHandler.openView(View.NURSE_MAIN);
  }

  @FXML public void onClearButton()
  {
    viewModel.clearAppointment();
  }

  @FXML public void onSeeAllAppointmentsButton()
  {
    SelectionModel.getInstance().setLastOpenedView(View.MAKE_APPOINTMENT);
    viewHandler.openView(View.ALL_APPOINTMENTS);
  }


  @Override
  public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
    this.viewModel = (MakeAppointmentViewModel) viewModelFactory.getViewModel(View.MAKE_APPOINTMENT);
    doctorsTableViewMakeAppointment.setItems(viewModel.getAvailableDoctors());
    firstNameColumnDoctors.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    lNameColumnDoctors.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    ssnColumnDoctors.setCellValueFactory(new PropertyValueFactory<>("ssn"));
    patientsTableViewMakeAppointment.setItems(viewModel.getAllPatients());
    fNameColumnPatients.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    lNameColumnPatients.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    ssnColumnPatients.setCellValueFactory(new PropertyValueFactory<>("ssn"));

    makeAppointmentDateField.valueProperty().bindBidirectional(
        viewModel.appointmentDateProperty());
    timeMakeAppointmentTxtField.textProperty().bindBidirectional(viewModel.appointmentTimeProperty());

    viewModel.loadPatientData();
    viewModel.loadDoctorData();
  }

}
