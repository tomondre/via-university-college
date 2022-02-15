package Ex5_3.view.all;

import Ex5_3.model.Task;
import Ex5_3.model.TaskModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AllTaskVM implements PropertyChangeListener
{
  private ObservableList<Task> tasks;
  private TaskModel model;

  public AllTaskVM(TaskModel model)
  {
    this.model = model;
    tasks = FXCollections.observableArrayList();
    this.model.addPropertyChangeListener(this);
  }

  public ObservableList<Task> getTaskList()
  {
    return tasks;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    tasks.setAll(model.getTasks());
  }
}
