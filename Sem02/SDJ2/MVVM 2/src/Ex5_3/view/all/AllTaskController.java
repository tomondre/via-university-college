package Ex5_3.view.all;

import Ex5_3.core.ViewHandler;
import Ex5_3.model.Task;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class AllTaskController
{
  public Button nextTaskButton;
  public Button addButton;
  public TableView<Task> table;
  public TableColumn<String, Task> descriptionColumn;
  public TableColumn<String, Task> creatorColumn;
  public TableColumn<String, Task> dateColumn;

  private AllTaskVM viewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, AllTaskVM allTaskVM)
  {
    this.viewModel = allTaskVM;
    this.viewHandler = viewHandler;
    creatorColumn.setCellValueFactory(new PropertyValueFactory<>("owner"));
    descriptionColumn
        .setCellValueFactory(new PropertyValueFactory<>("description"));
    dateColumn.setCellValueFactory(new PropertyValueFactory<>("timeCreated"));
    table.setItems(viewModel.getTaskList());
  }

  public void onAddButton(ActionEvent actionEvent) throws IOException
  {
    viewHandler.openAddTaskView();
  }

  public void onNextTask(ActionEvent actionEvent) throws IOException
  {
viewHandler.openNextTaskView();
  }
}
