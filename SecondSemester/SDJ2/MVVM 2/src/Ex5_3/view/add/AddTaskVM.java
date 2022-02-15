package Ex5_3.view.add;

import Ex5_3.model.TaskModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AddTaskVM
{
  private StringProperty creator;
  private StringProperty description;
  private TaskModel model;

  public AddTaskVM(TaskModel model)
  {
    this.model = model;
    creator = new SimpleStringProperty();
  description = new SimpleStringProperty();
  }

  public void addNewTask()
  {
    model.addTask(creator.get(), description.get());
  }

  public StringProperty creatorProperty()
  {
    return creator;
  }

  public StringProperty descriptionProperty()
  {
    return description;
  }

  public void reset()
  {
    creator.set("");
    description.set("");
  }
}
