package client.view.doctor;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.sharted.View;
import client.view.sharted.ViewController;
import client.view_models.doctor.EditMedicalDescriptionViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PatientInfoViewController implements ViewController
{
  @FXML private TextField patientsFirstName;
  @FXML private TextField patientsMiddleName;
  @FXML private TextField patientsLastName;
  @FXML private TextField contactFirstName;
  @FXML private TextField contactLastName;
  @FXML private TextField contactTelNo;
  @FXML private TextField street;
  @FXML private TextField no;
  @FXML private TextField city;
  @FXML private TextField zipCode;
  @FXML private TextField gender;
  @FXML private TextField bloodType;
  @FXML private TextField ssn;
  @FXML private TextArea medicalDescriptionTextArea;
  @FXML private TextField dateOfBirth;

  private ViewHandler viewHandler;
  private EditMedicalDescriptionViewModel viewModel;

  @FXML public void onBackButton()
  {
    viewHandler.openView(View.PATIENTS);
  }

  @Override public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
    viewModel = (EditMedicalDescriptionViewModel) viewModelFactory
        .getViewModel(View.PATIENT_INFO);

    viewModel.refreshPatient();

    patientsFirstName.textProperty().bind(viewModel.firstNameProperty());
    patientsMiddleName.textProperty().bind(viewModel.middleNameProperty());
    patientsLastName.textProperty().bind(viewModel.lastNameProperty());
    ssn.textProperty().bind(viewModel.ssnProperty());
    dateOfBirth.textProperty().bind(viewModel.dateOfBirthProperty());
    gender.textProperty().bind(viewModel.genderProperty());
    bloodType.textProperty().bind(viewModel.bloodTypeProperty());
    street.textProperty().bind(viewModel.streetProperty());
    no.textProperty().bind(viewModel.noProperty());
    city.textProperty().bind(viewModel.cityProperty());
    zipCode.textProperty().bind(viewModel.zipCodeProperty());
    contactFirstName.textProperty().bind(viewModel.cFirstNameProperty());
    contactLastName.textProperty().bind(viewModel.cLastNameProperty());
    contactTelNo.textProperty().bind(viewModel.cTelNoProperty());
    medicalDescriptionTextArea.textProperty().bind(viewModel.medicalDescriptionProperty());
  }

}
