package client.view.manager;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.shared.SelectionModel;
import client.view.sharted.Alerts;
import client.view.sharted.View;
import client.view.sharted.ViewController;
import client.view_models.manager.WardViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.Ward;

import java.security.InvalidParameterException;

public class WardViewController implements ViewController
{
    @FXML
    private TableView<Ward> wardTable;
    @FXML
    private TableColumn<String, Ward> wardNameColumn;
    @FXML
    private TableColumn<Integer, Ward> roomNumberColumn;

    private ViewHandler viewHandler;
    private WardViewModel wardViewModel;

    @FXML
    public void onAddWardButton()
    {
        viewHandler.openView(View.ADD_EDIT_WARD);
    }

    @FXML
    public void onRemoveWardButton()
    {
        SelectionModel.getInstance().set(wardTable.getSelectionModel().getSelectedItem());
        try
        {
            wardViewModel.removeWard();
            Alerts.throwAlert(Alert.AlertType.INFORMATION, "Ward successfully removed.");
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
        this.viewHandler=viewHandler;
        this.wardViewModel = (WardViewModel) viewModelFactory.getViewModel(View.WARD);
        wardTable.setItems(wardViewModel.getWards());
        wardNameColumn.setCellValueFactory(new PropertyValueFactory<>("wardName"));
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));

        wardViewModel.loadWards();
    }
}
