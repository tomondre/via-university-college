package Ex.core;

import Ex.view.list.ListViewController;
import Ex.view.manage.ManageViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private ViewModelFactory vmf;

  private Stage stage;
  private Scene manageScene;
  private Scene listScene;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }

  public void start() throws IOException
  {
    stage = new Stage();
   openListView();
  }

  public void openManageView(String action) throws IOException
  {
    openView("ManageView");
  }

  public void openListView() throws IOException
  {
    openView("ListView");
  }

  private void openView(String view) throws IOException
  {
    stage = new Stage();
    FXMLLoader loader = new FXMLLoader();
    if (view.equals("ManageView"))
    {
      if (manageScene == null)
      {
        loader.setLocation(getClass().getResource("../view/manage/ManageView.fxml"));
        Parent root = loader.load();

        ManageViewController controller = loader.getController();
        controller.init(this, vmf.getManageExerciseViewModel());
        manageScene = new Scene(root);
      }
      stage.setScene(manageScene);
    }

    else if (view.equals("ListView"))
    {
      if (listScene == null)
      {
        loader.setLocation(getClass().getResource("../view/list/ListView.fxml"));
        Parent root = loader.load();

        ListViewController allTaskController = loader.getController();
        allTaskController.init(this, vmf.getListExerciseViewModel());
        listScene = new Scene(root);
      }
      stage.setScene(listScene);
    }
    stage.show();
  }

}
