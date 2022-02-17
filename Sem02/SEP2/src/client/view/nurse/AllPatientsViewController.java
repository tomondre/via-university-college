package client.view.nurse;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.shared.SelectionModel;
import client.view.sharted.Alerts;
import client.view.sharted.View;
import client.view.sharted.ViewController;
import client.view_models.nurse.AllPatientsViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.Patient;

import java.security.InvalidParameterException;

public class AllPatientsViewController implements ViewController
{
    @FXML private
    TableView<Patient> patientsTable;
    @FXML private TableColumn<Patient, Long> patientFNameColumn;
    @FXML private TableColumn<Patient, String> patientLNameColumn;
    @FXML private TableColumn<Patient, String> patientSSNColumn;

    private ViewHandler viewHandler;
    private AllPatientsViewModel viewModel;

    @FXML
    public void onAddPatientButton()
    {
        viewHandler.openView(View.ADD_PATIENT);
    }

    @FXML
    public void onEditButton()
    {
        SelectionModel.getInstance().set(patientsTable.getSelectionModel().getSelectedItem());
        try
        {
            viewModel.editPatient();
            viewHandler.openView(View.ADD_PATIENT);
        }
        catch (InvalidParameterException e)
        {
            Alerts.throwAlert(Alert.AlertType.ERROR, e.getMessage());
        }
    }

    @FXML
    public void onRemovePatientButton()
    {
        try
        {
            viewModel.removePatient(patientsTable.getSelectionModel().getSelectedItem());
            Alerts.throwAlert(Alert.AlertType.INFORMATION, "Patient successfully removed.");
        }
        catch (InvalidParameterException e)
        {
            Alerts.throwAlert(Alert.AlertType.ERROR, e.getMessage());
        }
    }

    @FXML
    public void onBackButton()
    {
       viewHandler.openView(View.NURSE_MAIN);
    }

    @Override
    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
        viewModel = (AllPatientsViewModel) viewModelFactory.getViewModel(View.All_PATIENTS);

        patientsTable.setItems(viewModel.allPatientsProperty());
        patientFNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        patientLNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        patientSSNColumn.setCellValueFactory(new PropertyValueFactory<>("ssn"));

        viewModel.loadPatientsData();
    }
}
