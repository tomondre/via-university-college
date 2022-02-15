package client.view.login;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.sharted.View;
import client.view.sharted.ViewController;
import client.view_models.login.LoginViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class LoginViewController implements ViewController
{
    @FXML
    private TextField usernameTextFieldLogin;
    @FXML
    private PasswordField passwordFieldLogin;
    @FXML
    private RadioButton managerRadioLogin;
    @FXML
    private RadioButton doctorRadioLogin;
    @FXML
    private RadioButton nurseRadioLogin;
    @FXML
    private Label errorLabelLogin;

    private ViewHandler viewHandler;
    private LoginViewModel loginViewModel;

    @FXML
    public void onLoginButton()
    {
        View viewToOpen = loginViewModel.login();
        viewHandler.openView(viewToOpen);
    }

    @Override
    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
        this.loginViewModel = (LoginViewModel) viewModelFactory.getViewModel(View.LOGIN);
        usernameTextFieldLogin.textProperty().bindBidirectional(loginViewModel.getUsernameProperty());
        passwordFieldLogin.textProperty().bindBidirectional(loginViewModel.getPasswordProperty());
        managerRadioLogin.selectedProperty().bindBidirectional(loginViewModel.getManagerProperty());
        doctorRadioLogin.selectedProperty().bindBidirectional(loginViewModel.getDoctorProperty());
        nurseRadioLogin.selectedProperty().bindBidirectional(loginViewModel.getNurseProperty());
        errorLabelLogin.textProperty().bindBidirectional(loginViewModel.getErrorLabel());
    }
}
