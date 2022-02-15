package Ex6_3.core;

import Ex6_3.view.DoorViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private Scene scene;
  private ViewModelFactory vmf;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }

  public void start() throws IOException
  {
    stage = new Stage();
    openView();
  }

  private void openView() throws IOException
  {

    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource("../view/Door.fxml"));
    root = loader.load();

    DoorViewController view = loader.getController();
    view.init(vmf.getDoorVM());
    stage.setTitle("Door");

    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

  }

}
