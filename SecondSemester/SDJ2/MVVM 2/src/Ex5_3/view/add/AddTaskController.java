package Ex5_3.view.add;

import Ex5_3.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddTaskController
{
  public Button addButton;
  public Button backButton;
  public TextField taskDescription;
  public TextField taskCreator;

  private AddTaskVM viewModel;
  private ViewHandler handler;

  public void init(ViewHandler handler, AddTaskVM viewModel)
  {
    this.handler = handler;
    this.viewModel = viewModel;
    taskDescription.textProperty().bindBidirectional(viewModel.descriptionProperty());
    taskCreator.textProperty().bindBidirectional(viewModel.creatorProperty());
  }

  public void onAddButton(ActionEvent actionEvent)
  {
    viewModel.addNewTask();
  }

  public void onBackButton(ActionEvent actionEvent) throws IOException
  {
viewModel.reset();
    handler.openAllTaskView();
  }

}
