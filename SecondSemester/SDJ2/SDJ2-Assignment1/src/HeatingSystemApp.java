import client.core.ModelFactory;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class HeatingSystemApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {

    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);

    vh.start();
  }
}