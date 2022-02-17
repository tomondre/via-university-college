package Ex5_3;

import Ex5_3.core.ModelFactory;
import Ex5_3.core.ViewHandler;
import Ex5_3.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class TaskListApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);
    vh.start();
  }
}
