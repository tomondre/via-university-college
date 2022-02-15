package server.core;

import server.MessengerManager;
import server.ServerModel;

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
