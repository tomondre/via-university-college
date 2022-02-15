package Ex6_3.core;

import Ex6_3.model.Door;
import Ex6_3.model.DoorModel;

public class ModelFactory
{
  DoorModel model;

  public ModelFactory()
  {
    model = new Door();
  }

  public DoorModel getDoorModel()
  {
    return model;
  }
}
