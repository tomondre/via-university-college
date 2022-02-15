package Ex22_2.client;

import Ex22_2.client.core.ClientFactory;
import Ex22_2.client.core.ModelFactory;
import Ex22_2.client.core.ViewHandler;
import Ex22_2.client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class RunClient extends Application
{
  @Override public void start(Stage stage)
  {
    ViewHandler vh = ViewHandler.getInstance();

    vh.start();
  }
}
