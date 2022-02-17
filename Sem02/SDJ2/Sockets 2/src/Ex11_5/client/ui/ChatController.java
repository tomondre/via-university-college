package Ex11_5.client.ui;

import Ex11_5.client.networking.SocketClient;
import Ex11_5.transferobjects.Message;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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

  private SocketClient client;
  private String name;

  public void init(SocketClient client)
  {
    this.client = client;
    name = "unnamed";
  }

  public void onSetNameButton(ActionEvent actionEvent)
  {
    client.sendMessage(new Message(
        "Client " + name + ", has changed name to: " + nameField.getText()));
    name = nameField.getText();
    nameField.setText("");
    nameField.setPromptText(name);
  }

  public void onSendMessageButton(ActionEvent actionEvent)
  {
    System.out.println(client);
    Platform.runLater(() -> {
      client.sendMessage(new Message(name + ": " + messageField.getText()));
    });
  }

  public void messageReceived(Message message)
  {
    if (client == null)
    {
      client = new SocketClient(this);
    }
    chatArea.appendText(" \n" + message.get());
  }
}
