package Ex5_3.core;

import Ex5_3.model.TaskModel;
import Ex5_3.model.TaskModelManager;

public class ModelFactory
{
  private TaskModel model;

  public TaskModel getTaskModel()
  {
    if (model==null)
    {
      model = new TaskModelManager();
    }
    return model;
  }
}
