package Ex4_3.view;

import Ex4_3.core.ViewModelFactory;
import Ex4_3.view.log.LogViewController;
import Ex4_3.view.uppercase.UppercaseViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private Scene scene;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
  }

  public void start(String view) throws Exception
  {
    openView(view);
  }

  public void openView(String view) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    if (view.equals("Log"))
    {
      loader.setLocation(getClass().getResource("../Ex5_1.view/log/LogView.fxml"));
    }
    else
    {
      loader.setLocation(
          getClass().getResource("../Ex5_1.view/uppercase/UppercaseView.fxml"));
    }
    Parent root = null;

    root = loader.load();

    if (view.equals("Log"))
    {
      LogViewController logViewController = loader.getController();
      logViewController.init(this, viewModelFactory.getLogVM());
    }
    else
    {
      UppercaseViewController uppercaseViewController = loader.getController();
      uppercaseViewController.init(this, viewModelFactory.getUppercaseVM());
    }
    scene = new Scene(root);
    stage = new Stage();
    stage.setScene(scene);
    stage.show();
  }
}