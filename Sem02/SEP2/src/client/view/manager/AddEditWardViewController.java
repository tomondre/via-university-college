package client.view.manager;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.sharted.Alerts;
import client.view.sharted.View;
import client.view.sharted.ViewController;
import client.view_models.manager.AddEditWardViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.Ward;

import java.security.InvalidParameterException;

public class AddEditWardViewController implements ViewController
{
    @FXML
    private TableView<Ward> allWardsTable;
    @FXML
    private TableColumn<Ward, String> wardNameColumn;
    @FXML
    private TableColumn<Ward, Integer> wardRoomNumberColumn;
    @FXML
    private TextField wardNameTextField;
    @FXML
    private TextField wardRoomNumber;

    private ViewHandler viewHandler;
    private AddEditWardViewModel viewModel;

    @FXML
    public void onSaveButton()
    {
        try
        {
            viewModel.saveChanges();
            Alerts.throwAlert(Alert.AlertType.INFORMATION, "Ward successfully added.");
        }
        catch (InvalidParameterException e)
        {
            Alerts.throwAlert(Alert.AlertType.ERROR, e.getMessage());
        }
    }

    @FXML
    public void onClearButton()
    {
        viewModel.clear();
    }

    @FXML
    public void onBackButton()
    {
        viewModel.clear();
        viewHandler.openView(View.WARD);
    }

    @Override
    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
        this.viewModel = (AddEditWardViewModel) viewModelFactory.getViewModel(View.ADD_EDIT_WARD);
        allWardsTable.setItems(viewModel.getAllWards());
        wardNameColumn.setCellValueFactory(new PropertyValueFactory<>("wardName"));
        wardRoomNumberColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        wardNameTextField.textProperty().bindBidirectional(viewModel.wardNameProperty());
        wardRoomNumber.textProperty().bindBidirectional(viewModel.roomNumberProperty());

        viewModel.fillWards();
    }
}
