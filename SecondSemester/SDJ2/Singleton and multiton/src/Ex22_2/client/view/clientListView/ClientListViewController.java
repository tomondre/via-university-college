package Ex22_2.client.view.clientListView;

import Ex22_2.client.core.ViewHandler;
import Ex22_2.client.core.ViewModelFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ClientListViewController
{

  public TableView<String> clientListTable;
  public TableColumn<String, String> clientListColumn;
  public Button backButton;
  private ViewHandler handler;
  private ClientListViewModel viewModel;

  public void init()
  {
    this.handler = ViewHandler.getInstance();
    this.viewModel = ViewModelFactory.getInstance().getClientListViewModel();
    clientListColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
    clientListTable.setItems(viewModel.getClientList());
  }

  public void onBackButton(ActionEvent actionEvent)
  {
    handler.openChatView();
  }
}
