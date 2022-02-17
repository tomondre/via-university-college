package client.view.manager;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.sharted.Alerts;
import client.view.sharted.View;
import client.view.sharted.ViewController;
import client.view_models.manager.AddEditEmployeeViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import shared.Ward;

import java.security.InvalidParameterException;

public class AddEditEmployeeViewController implements ViewController
{

    @FXML
    private TextField employeeSSNTextField;
    @FXML
    private TextField employeeFirstNameTextField;
    @FXML
    private TextField employeeMidNameTextField;
    @FXML
    private TextField employeeLastNameTextField;
    @FXML
    private DatePicker employeeDOBDateField;
    @FXML
    private TextField employeeStreetTextField;
    @FXML
    private TextField employeeStreetNoTextField;
    @FXML
    private TextField employeeZipCodeTextField;
    @FXML
    private TextField employeeCityTextField;
    @FXML
    private TextField employeeEContactFNameTextField;
    @FXML
    private TextField employeeEContactLNameTextField;
    @FXML
    private TextField employeeEContactPhoneTextField;


    @FXML
    private ComboBox<Ward> employeeWardComboBox;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextArea employeeExperienceTextArea;
    @FXML
    private TextArea employeeEducationTextArea;

    private ViewHandler viewHandler;
    private AddEditEmployeeViewModel viewModel;

    @FXML
    public void onSaveButtonEmployee()
    {
        try
        {
            viewModel.saveChanges();
            Alerts.throwAlert(Alert.AlertType.INFORMATION, "Employee successfully added.");
        }
        catch (InvalidParameterException e)
        {
           Alerts.throwAlert(Alert.AlertType.ERROR, e.getMessage());
        }
    }

    @FXML
    public void onClearButtonEmployee()
    {
        viewModel.clear();
    }

    @FXML
    public void onBackButtonEmployee()
    {
        viewModel.clear();
        viewHandler.openView(View.EMPLOYEE);
    }

    @Override
    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
        this.viewModel = (AddEditEmployeeViewModel) viewModelFactory.getViewModel(View.ADD_EDIT_EMPLOYEE);
        employeeSSNTextField.textProperty().bindBidirectional(viewModel.employeeSnnProperty());
        employeeFirstNameTextField.textProperty().bindBidirectional(viewModel.employeeFirstNameProperty());
        employeeMidNameTextField.textProperty().bindBidirectional(viewModel.employeeMiddleNameProperty());
        employeeLastNameTextField.textProperty().bindBidirectional(viewModel.employeeLastNameProperty());
        employeeDOBDateField.valueProperty().bindBidirectional(viewModel.employeeDobProperty());
        employeeStreetTextField.textProperty().bindBidirectional(viewModel.employeeStreetProperty());
        employeeStreetNoTextField.textProperty().bindBidirectional(viewModel.employeeStreetNoProperty());
        employeeCityTextField.textProperty().bindBidirectional(viewModel.employeeCityProperty());
        employeeZipCodeTextField.textProperty().bindBidirectional(viewModel.employeeZipCodeProperty());
        employeeEContactFNameTextField.textProperty().bindBidirectional(viewModel.contactFirstNameProperty());
        employeeEContactLNameTextField.textProperty().bindBidirectional(viewModel.contactLastNameProperty());
        employeeEContactPhoneTextField.textProperty().bindBidirectional(viewModel.contactPhoneNoProperty());
        employeeWardComboBox.valueProperty().bindBidirectional(viewModel.selectedEmployeeWardProperty());
        employeeWardComboBox.setItems(viewModel.wardsProperty());
        usernameTextField.textProperty().bindBidirectional(viewModel.usernameProperty());
        passwordTextField.textProperty().bindBidirectional(viewModel.passwordProperty());
        employeeExperienceTextArea.textProperty().bindBidirectional(viewModel.experienceProperty());
        employeeEducationTextArea.textProperty().bindBidirectional(viewModel.educationProperty());
        viewModel.setChangeType();
        viewModel.getWards();
    }
}
