package client;

import client.core.ClientFactory;
import client.core.ModelFactory;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class RunClient extends Application
{
  @Override public void start(Stage stage)
  {
    ClientFactory client = new ClientFactory();
    ModelFactory mf = new ModelFactory(client);
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);

    vh.start();
  }
}
