package Ex6_3;

import Ex6_3.core.ModelFactory;
import Ex6_3.core.ViewHandler;
import Ex6_3.core.ViewModelFactory;
import Ex6_3.model.Door;
import javafx.application.Application;
import javafx.stage.Stage;

public class DoorApp extends Application
{

  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory vm = new ViewModelFactory(modelFactory);
    ViewHandler handler = new ViewHandler(vm);

    handler.start();
  }
}
