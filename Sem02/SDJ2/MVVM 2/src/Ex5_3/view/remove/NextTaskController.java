package Ex5_3.view.remove;

import Ex5_3.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class NextTaskController
{

  public Label creatorLabel;
  public Label descriptionLabel;
  public Button backButton;
  public Button getTask;
  public Label dateLabel;
  private NextTaskVM viewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler vh, NextTaskVM vm)
  {
    this.viewModel = vm;
    this.viewHandler = vh;
    viewModel.getNextTask();
    creatorLabel.textProperty().bind(viewModel.creator());
    descriptionLabel.textProperty().bind(viewModel.description());
    dateLabel.textProperty().bind(viewModel.date());
  }

  public void onGetTask(ActionEvent actionEvent)
  {
viewModel.getNextTask();
  }

  public void onBack(ActionEvent actionEvent) throws IOException
  {
    viewHandler.openAllTaskView();
  }
}
