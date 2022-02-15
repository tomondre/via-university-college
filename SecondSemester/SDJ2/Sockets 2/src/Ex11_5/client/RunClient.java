package Ex11_5.client;

import Ex11_5.client.networking.SocketClient;
import Ex11_5.client.ui.ChatController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RunClient extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("ui/Chat.fxml"));
    Parent root = loader.load();
    ChatController controller = loader.getController();

    SocketClient client = new SocketClient(controller);
    controller.init(client);

    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
  }
}
