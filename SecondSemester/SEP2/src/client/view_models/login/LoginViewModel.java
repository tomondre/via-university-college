package client.view_models.login;

import client.model.login.Login;
import client.view.sharted.View;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.AccessType;
import shared.CurrentUser;
import shared.LoginUser;
import shared.Validator;

public class LoginViewModel
{
    private Login loginModel;
    private StringProperty username;
    private StringProperty password;
    private StringProperty errorLabel;
    private BooleanProperty managerProperty;
    private BooleanProperty doctorProperty;
    private BooleanProperty nurseProperty;
    private LoginUser loginUser;


    public LoginViewModel(Object loginModel)
    {
        this.loginModel = (Login) loginModel;
        this.username = new SimpleStringProperty("auctor.velit.eget@vitaemauris.com");
        this.password = new SimpleStringProperty("Q93rFxMnT2c6");
        this.errorLabel = new SimpleStringProperty();
        managerProperty = new SimpleBooleanProperty();
        doctorProperty = new SimpleBooleanProperty();
        nurseProperty = new SimpleBooleanProperty();
    }

    public View login()
    {
        if (!Validator.isValidEmail(username.getValue()))
        {
            errorLabel.setValue("Invalid username");
            username.setValue("");
            return View.LOGIN;
        }
        if (!Validator.isValidPassword(password.getValue()))
        {
            errorLabel.setValue("Invalid password");
            password.setValue("");
            return View.LOGIN;
        }

        if (managerProperty.getValue())
        {
            loginUser = new LoginUser(username.getValue(), password.getValue(), AccessType.MANAGER);

        }
        else if (doctorProperty.getValue())
        {
            loginUser = new LoginUser(username.getValue(), password.getValue(), AccessType.DOCTOR);

        }
        else if (nurseProperty.getValue())
        {
            loginUser = new LoginUser(username.getValue(), password.getValue(), AccessType.NURSE);

        }
        else
        {
            errorLabel.setValue("Please select login type.");
            return View.LOGIN;
        }

        AccessType login = loginModel.login(loginUser);
        if (login != AccessType.NO_ACCESS )
        {
            setCurrentUser();

        }
        return getAccess(login);
    }

    private View getAccess(AccessType login)
    {
        View view = null;
        switch (login)
        {
            case MANAGER:
                view = View.MANAGER_MAIN;
                break;
            case NO_ACCESS:
                errorLabel.setValue("Invalid username or password");
                view = View.LOGIN;
                break;
            case DOCTOR:
                view = View.DOCTOR_MAIN;
                break;
            case NURSE:
                view = View.NURSE_MAIN;
                break;
        }
        return view;
    }

    public void setCurrentUser()
    {
        CurrentUser.getInstance().setUser(loginUser);
    }

    public StringProperty getUsernameProperty()
    {
        return username;
    }

    public StringProperty getPasswordProperty()
    {
        return password;
    }

    public StringProperty getErrorLabel()
    {
        return errorLabel;
    }

    public BooleanProperty getManagerProperty()
    {
        return managerProperty;
    }

    public BooleanProperty getDoctorProperty()
    {
        return doctorProperty;
    }

    public BooleanProperty getNurseProperty()
    {
        return nurseProperty;
    }
}
