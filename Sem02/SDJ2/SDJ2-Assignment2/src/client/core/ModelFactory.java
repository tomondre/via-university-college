package client.core;

import client.model.ChatModel;
import client.model.Model;
import client.networking.Client;

public class ModelFactory
{
  private ClientFactory clientFactory;
  private Model model;

  public ModelFactory(ClientFactory client)
  {
    this.clientFactory = client;

    model = new ChatModel(client.getClient());
  }

  public Model getModel()
  {
    return model;
  }

}
