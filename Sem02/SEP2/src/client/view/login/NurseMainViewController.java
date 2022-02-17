package client.view.login;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.sharted.View;
import client.view.sharted.ViewController;
import client.view_models.login.NurseMainViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NurseMainViewController implements ViewController
{
    @FXML
    private Label loggedInAsLabel;
    private ViewHandler viewHandler;
    private NurseMainViewModel nurseMainViewModel;

    @FXML
    public void onPatientsButton()
    {
        viewHandler.openView(View.All_PATIENTS);
    }

    @FXML
    public void onAppointmentsButton()
    {
        viewHandler.openView(View.ALL_APPOINTMENTS);
    }

    @FXML
    public void onLogoutButton()
    {
        viewHandler.openView(View.LOGIN);
    }

    @Override
    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
        this.nurseMainViewModel = (NurseMainViewModel) viewModelFactory.getViewModel(View.NURSE_MAIN);
        loggedInAsLabel.textProperty().bind(nurseMainViewModel.currentUserProperty());

        nurseMainViewModel.setCurrentUser();
    }

    public void onNewAppointmentButton()
    {
        viewHandler.openView(View.MAKE_APPOINTMENT);
    }
}
