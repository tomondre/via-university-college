package Ex5_3.core;

import Ex5_3.view.add.AddTaskController;
import Ex5_3.view.all.AllTaskController;
import Ex5_3.view.remove.NextTaskController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{

  private String allTasksViewFXMLname = "AllTasksView";

  private Stage stage;
  private Scene addTaskViewScene;
  private Scene allTaskViewScene;
  private Scene nextTaskViewScene;
  private ViewModelFactory vmf;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }

  public void start() throws IOException
  {
    stage = new Stage();
    openAllTaskView();
  }

  public void openAddTaskView() throws IOException
  {
    openView("AddTaskView");
  }

  public void openAllTaskView() throws IOException
  {
    if (allTaskViewScene == null)
    {
      openView(allTasksViewFXMLname);
      return;
    }
    stage.close();
    stage.setScene(addTaskViewScene);
  }

  public void openNextTaskView() throws IOException
  {
    openView("NextTaskView");
  }

  private void openView(String view) throws IOException
  {
    String temp = "";
    FXMLLoader loader = new FXMLLoader();
    if (view.equals("AddTaskView"))
    {
      temp = "add";

    }
    else if (view.equals(allTasksViewFXMLname))
    {
      temp = "all";
    }
    else
    {
      temp = "remove";
    }
    loader.setLocation(
        getClass().getResource("../view/" + temp + "/" + view + ".fxml"));

    Parent root = null;

    root = loader.load();

    stage = new Stage();

    if (view.equals("AddTaskView"))
    {
      AddTaskController addTaskController = loader.getController();
      addTaskController.init(this, vmf.getAddTaskVM());
      addTaskViewScene = new Scene(root);
      stage.setScene(addTaskViewScene);
    }

    else if (view.equals(allTasksViewFXMLname))
    {
      AllTaskController allTaskController = loader.getController();
      allTaskController.init(this, vmf.getAllTaskVM());
      if (allTaskViewScene == null)
      {
        allTaskViewScene = new Scene(root);
      }
      stage.setScene(allTaskViewScene);
    }

    else
    {
      NextTaskController nextTaskController = loader.getController();
      nextTaskController.init(this, vmf.getNextTaskVM());

      nextTaskViewScene = new Scene(root);
      stage.setScene(nextTaskViewScene);
    }
    stage.show();
  }
}
