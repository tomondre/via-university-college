package Ex6_3.core;

import Ex6_3.view.DoorVM;
import Ex6_3.view.DoorViewController;

public class ViewModelFactory
{
  DoorVM viewModel;
  ModelFactory model;

  public ViewModelFactory(ModelFactory model){
    this.model = model;
    viewModel = new DoorVM(model.getDoorModel());
  }

  public DoorVM getDoorVM()
  {
    return viewModel;
  }
}
