package Ex5_3.core;

import Ex5_3.view.add.AddTaskVM;
import Ex5_3.view.all.AllTaskVM;
import Ex5_3.view.remove.NextTaskVM;

public class ViewModelFactory
{
  private AddTaskVM addTaskVM;
  private AllTaskVM allTaskVM;
  private NextTaskVM nextTaskVM;

  private ModelFactory model;

  public ViewModelFactory(ModelFactory model)
  {
    this.model = model;
    addTaskVM = new AddTaskVM(model.getTaskModel());
    allTaskVM = new AllTaskVM(model.getTaskModel());
    nextTaskVM = new NextTaskVM(model.getTaskModel());
  }

  public AddTaskVM getAddTaskVM()
  {
    return addTaskVM;
  }

  public AllTaskVM getAllTaskVM()
  {
    return allTaskVM;
  }

  public NextTaskVM getNextTaskVM()
  {
    return nextTaskVM;
  }
}
