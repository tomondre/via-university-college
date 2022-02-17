package client.view.login;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.sharted.View;
import client.view.sharted.ViewController;
import client.view_models.login.ManagerMainViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ManagerMainViewController implements ViewController
{
    @FXML
    private Label loggedInAsLabel;

    private ViewHandler viewHandler;
    private ManagerMainViewModel managerMainViewModel;

    @FXML
    public void onEmployeeButton()
    {
        viewHandler.openView(View.EMPLOYEE);
    }

    @FXML
    public void onWardsButton()
    {
        viewHandler.openView(View.WARD);
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
        this.managerMainViewModel = (ManagerMainViewModel) viewModelFactory.getViewModel(View.MANAGER_MAIN);
        loggedInAsLabel.textProperty().bind(managerMainViewModel.currentUserProperty());

        managerMainViewModel.setCurrentUser();
    }
}
