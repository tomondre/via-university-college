package client.core;

import client.networking.Client;
import client.networking.RMIClient;

public class ClientFactory
{
  private static ClientFactory instance = new ClientFactory();
  private Client rmiClient;

  private ClientFactory()
  {
    rmiClient = new RMIClient();
    rmiClient.startClient();
  }

  public Client getRmiClient()
  {
    return rmiClient;
  }

  public static ClientFactory getInstance()
  {
    return instance;
  }
}
