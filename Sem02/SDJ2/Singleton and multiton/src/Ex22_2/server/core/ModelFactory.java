package Ex22_2.server.core;

import Ex22_2.server.model.MessengerManager;
import Ex22_2.server.model.ServerModel;

public class ModelFactory
{
  private ServerModel model;


  public ServerModel getServerModel()
  {
    if(model == null)
    {
      model = new MessengerManager();
    }
    return model;
  }
}
