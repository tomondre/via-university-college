package client.view.doctor;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.shared.SelectionModel;
import client.view.sharted.Alerts;
import client.view.sharted.View;
import client.view.sharted.ViewController;
import client.view_models.doctor.AssignNurseViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.Nurse;

import java.security.InvalidParameterException;

public class AssignNurseViewController implements ViewController
{

    @FXML
    private TableColumn<Nurse, String> availableNurseFirstName;
    @FXML
    private TableColumn<Nurse, String> availableNurseLastName;
    @FXML
    private TableColumn<Nurse, Long> availableNurseSSN;
    @FXML
    private TableView<Nurse> assignedNurseTable;
    @FXML
    private TableColumn<Nurse, String> assignedNurseFirstName;
    @FXML
    private TableColumn<Nurse, String> assignedNurseLastName;
    @FXML
    private TableColumn<Nurse, Long> assignedNurseSSN;
    @FXML
    private TableView<Nurse> nursesTable;

    private ViewHandler viewHandler;
    private AssignNurseViewModel assignNurseViewModel;

    @FXML
    public void onAssignButton()
    {
        SelectionModel.getInstance().set(nursesTable.getSelectionModel().getSelectedItem());
        try
        {
            assignNurseViewModel.assignNurse();
            Alerts.throwAlert(Alert.AlertType.INFORMATION, "Nurse was successfully assigned.");
        }
        catch (InvalidParameterException e)
        {
            Alerts.throwAlert(Alert.AlertType.ERROR, e.getMessage());
        }
    }

    @FXML
    public void onBackButton()
    {
        viewHandler.openView(View.DOCTOR_MAIN);
    }

    @Override
    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
        assignNurseViewModel = (AssignNurseViewModel) viewModelFactory.getViewModel(View.ASSIGN_NURSE);
        nursesTable.setItems(assignNurseViewModel.getAvailableNurses());
        availableNurseFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        availableNurseLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        availableNurseSSN.setCellValueFactory(new PropertyValueFactory<>("ssn"));

        assignedNurseTable.setItems(assignNurseViewModel.getAssignedNurses());
        assignedNurseFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        assignedNurseLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        assignedNurseSSN.setCellValueFactory(new PropertyValueFactory<>("ssn"));
        loadTables();
    }

    public void loadTables()
    {
        assignNurseViewModel.loadTables();
    }
}
