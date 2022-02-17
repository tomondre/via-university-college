package Ex.core;

import Ex.model.Model;
import Ex.model.ModelManager;

public class ModelFactory
{
  private Model model;

  public ModelFactory()
  {
    model = new ModelManager();
  }

  public Model getModel()
  {
    return model;
  }
}
