package Ex4_2;

import Ex4_2.model.ModelFactory;
import Ex4_2.core.ViewHandler;
import Ex4_2.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class UppercaseApp extends Application
{

  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);
    vh.start();
  }
}
