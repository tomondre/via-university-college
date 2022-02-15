package Ex.core;

import Ex.view.list.ListViewModel;
import Ex.view.manage.ManageExerciseViewModel;

public class ViewModelFactory
{
  private ManageExerciseViewModel exerciseVM;
  private ListViewModel listVM;
  private ModelFactory model;

  public ViewModelFactory(ModelFactory model)
  {
    this.model = model;
    exerciseVM = new ManageExerciseViewModel();
    listVM = new ListViewModel(model.getModel());
  }

  public ManageExerciseViewModel getManageExerciseViewModel()
  {
    return exerciseVM;
  }

  public ListViewModel getListExerciseViewModel()
  {
    return listVM;
  }

  public ModelFactory getModel()
  {
    return model;
  }
}
