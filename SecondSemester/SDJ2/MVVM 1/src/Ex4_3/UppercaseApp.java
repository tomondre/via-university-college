package Ex4_3;

import Ex4_3.model.ModelFactory;
import Ex4_3.view.ViewHandler;
import Ex4_3.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class UppercaseApp extends Application
{

  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);
    vh.start("");
  }
}
