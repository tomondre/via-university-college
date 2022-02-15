package Ex22_2.client.core;

import Ex22_2.client.networking.Client;
import Ex22_2.client.networking.SocketClient;

public class ClientFactory
{
  private Client client;
  private static ClientFactory clientFactory = new ClientFactory();

  public static ClientFactory getInstance()
  {
    return clientFactory;
  }

  public Client getClient()
  {
    if (client == null)
    {
      client = new SocketClient();
    }
    return client;
  }

}
