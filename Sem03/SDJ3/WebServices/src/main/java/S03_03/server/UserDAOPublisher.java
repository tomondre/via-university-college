package S03_03.server;

import sun.rmi.transport.Endpoint;


public class UserDAOPublisher
{
  public static void main(String[] args)
  {
    Endpoint.publish("http://localhost:9999/user", new UserDAOImpl());
  }
}
