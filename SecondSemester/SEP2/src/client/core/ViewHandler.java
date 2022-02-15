package client.core;

import client.view.sharted.View;
import client.view.sharted.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ViewHandler
{
  private Stage stage;
  private static ViewHandler viewHandler;
  private static Lock lock = new ReentrantLock();

  private ViewHandler()
  {
    this.stage = new Stage();
    Image image = new Image(
        getClass().getResourceAsStream("../images/image.png"));
    stage.getIcons().add(image);
    stage.setResizable(false);
  }

  public static ViewHandler getViewHandler()
  {
    if (viewHandler == null)
    {
      synchronized (lock)
      {
        if (viewHandler == null)
        {
          viewHandler = new ViewHandler();
        }
      }
    }
    return viewHandler;
  }

  public void start()
  {
    ViewFactory.init();
    openView(View.LOGIN);
  }

  public void openView(View view)
  {
    Scene scene = ViewFactory.getScene(view);
    FXMLLoader userData = (FXMLLoader) scene.getUserData();
    ((ViewController) userData.getController()).init(ViewModelFactory.getViewModelFactory(), getViewHandler());
    stage.setScene(scene);
    stage.show();
  }
}
