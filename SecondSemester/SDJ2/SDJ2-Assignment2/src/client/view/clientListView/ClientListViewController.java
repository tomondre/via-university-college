package client.view.clientListView;

import client.core.ViewHandler;
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

  public void init(ViewHandler handler, ClientListViewModel viewModel)
  {
    this.handler = handler;
    this.viewModel = viewModel;
    clientListColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
    clientListTable.setItems(viewModel.getClientList());
  }

  public void onBackButton(ActionEvent actionEvent)
  {
    handler.openChatView();
  }
}
