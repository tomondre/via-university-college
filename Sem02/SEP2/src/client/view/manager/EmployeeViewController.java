package client.view.manager;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.shared.SelectionModel;
import client.view.sharted.Alerts;
import client.view.sharted.View;
import client.view.sharted.ViewController;
import client.view_models.manager.EmployeeViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.Employee;

import java.security.InvalidParameterException;

public class EmployeeViewController implements ViewController
{
    @FXML
    private ComboBox<String> employeeTypeComboBox;
    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private TableColumn<Long, Employee> ssnColumn;
    @FXML
    private TableColumn<String, Employee> fNameColumn;
    @FXML
    private TableColumn<String, Employee> lNameColumn;
    @FXML
    private ViewHandler viewHandler;
    @FXML
    private EmployeeViewModel viewModel;

    @FXML
    public void onGetButton()
    {
       viewModel.getEmployees();
    }

    @FXML
    public void onAddEmployeeButton()
    {
        viewModel.addEmployee();
        viewHandler.openView(View.ADD_EDIT_EMPLOYEE);
    }

    @FXML
    public void onEditEmployeeButton()
    {
        SelectionModel.getInstance().set(employeeTable.getSelectionModel().getSelectedItem());
        try
        {
            viewModel.editEmployee();
            viewHandler.openView(View.ADD_EDIT_EMPLOYEE);
        }
        catch (InvalidParameterException e)
        {
            Alerts.throwAlert(Alert.AlertType.ERROR, e.getMessage());
        }
    }

    @FXML
    public void onRemoveEmployeeButton()
    {
        SelectionModel.getInstance().set(employeeTable.getSelectionModel().getSelectedItem());
        try
        {
            viewModel.removeEmployee();
            Alerts.throwAlert(Alert.AlertType.INFORMATION, "Employee was successfully removed.");
        }
        catch (InvalidParameterException e)
        {
            Alerts.throwAlert(Alert.AlertType.ERROR, e.getMessage());
        }
    }

    @FXML
    public void onBackButton()
    {
        viewHandler.openView(View.MANAGER_MAIN);
    }

    @Override
    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
        this.viewModel = (EmployeeViewModel) viewModelFactory.getViewModel(View.EMPLOYEE);
        employeeTypeComboBox.setItems(viewModel.getEmployeeType());
        employeeTypeComboBox.getSelectionModel().selectFirst();
        ssnColumn.setCellValueFactory(new PropertyValueFactory<>("ssn"));
        fNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        employeeTable.setItems(viewModel.employeesProperty());
        employeeTypeComboBox.valueProperty().bindBidirectional(viewModel.selectedEmployeeTypeProperty());
        employeeTypeComboBox.getSelectionModel().selectFirst();
        viewModel.getEmployees();
    }
}
