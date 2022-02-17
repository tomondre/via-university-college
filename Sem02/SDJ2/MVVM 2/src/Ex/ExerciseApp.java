package Ex;

import Ex.core.ModelFactory;
import Ex.core.ViewHandler;
import Ex.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class ExerciseApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory m = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(m);
    ViewHandler h = new ViewHandler(vmf);

    h.start();

  }

}
