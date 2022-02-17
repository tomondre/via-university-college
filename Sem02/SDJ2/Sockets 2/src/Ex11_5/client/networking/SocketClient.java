package Ex11_5.client.networking;

import Ex11_5.client.ui.ChatController;
import Ex11_5.transferobjects.Message;
import javafx.application.Platform;

import java.io.IOException;
import java.net.Socket;

public class SocketClient
{
  private ChatController controller;
  private ClientSocketHandler handler;

  public SocketClient(ChatController controller)
  {
    this.controller = controller;
    try
    {
      Socket socket = new Socket("localhost", 1234);
      handler = new ClientSocketHandler(socket, this);
      new Thread(handler).start();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void sendMessage(Message message)
  {
    handler.sendMessage(message);
  }

  public void receiveMessage(Message message)
  {
    Platform.runLater(() -> {
      controller.messageReceived(message);
    });
  }
}
