package client.view.chat;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatController
{
  public TextField nameField;
  public TextField messageField;
  public Button setNameButton;
  public Button sendMessageButton;
  public TextArea chatArea;
  public Button numberOfClientsButton;
  public Button showClientsButton;

  private ViewHandler handler;
  private ChatViewModel viewModel;
  private String name;

  public void init(ViewHandler handler, ChatViewModel vm)
  {
    this.viewModel = vm;
    this.handler = handler;

    nameField.textProperty().bindBidirectional(vm.getNameProperty());
    messageField.textProperty().bindBidirectional(vm.getMessageProperty());
    chatArea.textProperty().bindBidirectional(vm.getChatProperty());

    chatArea.setEditable(false);
  }

  public void onSetNameButton(ActionEvent actionEvent)
  {
   viewModel.setName();
  }

  public void onSendMessageButton(ActionEvent actionEvent)
  {
    viewModel.sendMessage();
  }

  public void onNumberOfClientsButton(ActionEvent actionEvent)
  {
    int numberOfClients = viewModel.getNumberOfConnectedClients();

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Information Dialog");
    alert.setHeaderText(null);
    alert.setContentText("Number Of Connected Clients: " + numberOfClients);

    alert.show();
  }

  public void onShowClientButton(ActionEvent actionEvent)
  {
    handler.openClientListView();
  }
}
