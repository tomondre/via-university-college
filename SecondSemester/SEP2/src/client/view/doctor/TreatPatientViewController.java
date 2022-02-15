package client.view.doctor;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.sharted.Alerts;
import client.view.sharted.View;
import client.view.sharted.ViewController;
import client.view_models.doctor.TreatPatientViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.Diagnosis;
import shared.Treatment;

import java.security.InvalidParameterException;

public class TreatPatientViewController implements ViewController
{
  public TableView<Treatment> allTreatmentsTable;
  public TableColumn<Treatment, String> treatmentMedication;
  public TableColumn<Treatment, String> treatmentDescription;
  public TableColumn<Treatment, String> treatmentDiagnosisName;
  public TableColumn<Treatment, String> treatmentDiagnosisSL;
  public ComboBox<String> medicationTypeCB;

  @FXML private TableView<Diagnosis> diagnosisTable;
  @FXML private TableColumn<Diagnosis, String> diagnosisName;
  @FXML private TableColumn<Diagnosis, Integer> diagnosisSeverity;
  @FXML private TableColumn<Diagnosis, String> diagnosisDescription;
  @FXML private TextArea descriptionTextArea;

  private ViewHandler viewHandler;

  private TreatPatientViewModel treatPatientViewModel;

  @FXML public void onAddButton()
  {
    try
    {
      treatPatientViewModel
          .addTreatment(medicationTypeCB.getSelectionModel().getSelectedItem(),
              diagnosisTable.getSelectionModel().getSelectedItem());
      treatPatientViewModel.loadDiagnoses();
      Alerts.throwAlert(Alert.AlertType.INFORMATION, "Treatment was successfully added.");
    }
    catch (InvalidParameterException e)
    {
      Alerts.throwAlert(Alert.AlertType.ERROR, e.getMessage());
    }
  }

  @FXML public void onBackButton()
  {
    viewHandler.openView(View.PATIENTS);
  }

  @FXML public void onClearButton()
  {
    descriptionTextArea.clear();
  }

  @Override public void init(ViewModelFactory viewModelFactory,
      ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
    treatPatientViewModel = (TreatPatientViewModel) viewModelFactory
        .getViewModel(View.TREAT_PATIENT);
    treatPatientViewModel.loadSelectedPatient();
    treatPatientViewModel.loadTreatments();
    treatPatientViewModel.loadDiagnoses();

    diagnosisTable.setItems(treatPatientViewModel.getDiagnoses());
    diagnosisName.setCellValueFactory(new PropertyValueFactory<>("name"));
    diagnosisSeverity
        .setCellValueFactory(new PropertyValueFactory<>("severityLevel"));
    diagnosisDescription
        .setCellValueFactory(new PropertyValueFactory<>("description"));
    descriptionTextArea.textProperty()
        .bindBidirectional(treatPatientViewModel.descriptionProperty());

    allTreatmentsTable.setItems(treatPatientViewModel.getTreatments());
    treatmentDescription
        .setCellValueFactory(new PropertyValueFactory<>("description"));
    treatmentDiagnosisName
        .setCellValueFactory(new PropertyValueFactory<>("diagnosisName"));
    treatmentDiagnosisSL
        .setCellValueFactory(new PropertyValueFactory<>("severityLevel"));
    treatmentMedication
        .setCellValueFactory(new PropertyValueFactory<>("medication"));

    medicationTypeCB.getItems()
        .setAll("Drops", "Cough syrup", "Capsule", "Aspirin", "Inhaler", "Tea",
            "Antibiotics");
  }

}
