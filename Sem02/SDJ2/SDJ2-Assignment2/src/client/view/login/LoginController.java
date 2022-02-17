package client.view.login;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController
{
  public TextField nameField;
  public Button submitButton;

  private LoginViewModel viewModel;
  private ViewHandler handler;

  public void init(LoginViewModel loginVM, ViewHandler viewHandler)
  {
    this.viewModel = loginVM;
    this.handler = viewHandler;
    nameField.textProperty().bindBidirectional(loginVM.getNameProperty());
  }

  public void onSubmitButton(ActionEvent actionEvent)
  {
    viewModel.setName();
    handler.openChatView();
  }
}
