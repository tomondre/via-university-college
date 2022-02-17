package client.view.login;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.shared.SelectionModel;
import client.view.sharted.View;
import client.view.sharted.ViewController;
import client.view_models.login.DoctorMainViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DoctorMainViewController implements ViewController
{
    @FXML
    public Label nrOfAppointments;
    @FXML
    private Label loggedInAsLabel;

    private ViewHandler viewHandler;
    private DoctorMainViewModel doctorMainViewModel;

    @FXML
    public void onLogoutButton()
    {
        viewHandler.openView(View.LOGIN);
    }

    @FXML
    public void onAppointmentButton()
    {
        viewHandler.openView(View.APPOINTMENTS);
    }

    @FXML
    public void onAssignNurseButton()
    {
        viewHandler.openView(View.ASSIGN_NURSE);
    }

    @FXML
    public void onPatientsButton()
    {
        viewHandler.openView(View.PATIENTS);
    }

    @Override
    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
        this.doctorMainViewModel = (DoctorMainViewModel) viewModelFactory.getViewModel(View.DOCTOR_MAIN);
        loggedInAsLabel.textProperty().bind(doctorMainViewModel.currentUserProperty());
        nrOfAppointments.textProperty().bind(doctorMainViewModel.nrOfAppointmentsProperty());
        doctorMainViewModel.setCurrentUser();
    }

    @FXML
    public void onSamplesButton()
    {
        SelectionModel.getInstance().setLastOpenedView(View.DOCTOR_MAIN);
        viewHandler.openView(View.PATIENTS_SAMPLE);
    }
}
