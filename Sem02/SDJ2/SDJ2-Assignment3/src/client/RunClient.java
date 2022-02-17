package client;

import client.core.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class RunClient extends Application
{
  @Override public void start(Stage stage)
  {
    ViewHandler.getInstance().start();
  }
}
