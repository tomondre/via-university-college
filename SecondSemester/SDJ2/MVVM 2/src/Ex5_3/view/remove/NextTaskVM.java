package Ex5_3.view.remove;

import Ex5_3.model.Task;
import Ex5_3.model.TaskModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NextTaskVM
{
  private StringProperty description;
  private StringProperty creator;
  private StringProperty date;
  private TaskModel model;

  public NextTaskVM(TaskModel model)
  {
    this.model = model;
    description = new SimpleStringProperty();
    creator = new SimpleStringProperty();
    date = new SimpleStringProperty();
  }

  public void getNextTask()
  {
    Task task = model.getNextTask();
    if (task != null)
    {
      description.setValue(task.getDescription());
      creator.setValue(task.getOwner());
      date.setValue(task.getTimeCreated());
    }
  }

  public StringProperty description()
  {
    return description;
  }

  public StringProperty creator()
  {
    return creator;
  }

  public StringProperty date()
  {
    return date;
  }

}
