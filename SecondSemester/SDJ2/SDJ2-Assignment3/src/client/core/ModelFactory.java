package client.core;

import client.model.ChatModel;
import client.model.Model;

public class ModelFactory
{
  private static ModelFactory modelFactory = new ModelFactory();
  private Model model;

  private ModelFactory()
  {
    model = new ChatModel(ClientFactory.getInstance().getRmiClient());
  }

  public static ModelFactory getInstance()
  {
    return modelFactory;
  }

  public Model getModel()
  {
    return model;
  }

}
