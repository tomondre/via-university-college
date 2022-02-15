package Ex12_1.client.model;

import Ex12_1.client.network.Client;
import Ex12_1.client.network.SocketClient;

public class ClientFactory
{
  private Client client;

  public Client getClient()
  {
    if (client == null){
      client = new SocketClient();
    }
    return client;
  }
}
