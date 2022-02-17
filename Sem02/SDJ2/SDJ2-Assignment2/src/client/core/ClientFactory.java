package client.core;

import client.networking.Client;
import client.networking.SocketClient;

public class ClientFactory
{
  private Client client;

  public Client getClient()
  {
    if (client == null)
    {
      client = new SocketClient();
    }
    return client;
  }
}
