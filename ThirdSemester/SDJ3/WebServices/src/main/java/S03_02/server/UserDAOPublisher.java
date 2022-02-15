package S03_02.server;

import javax.xml.ws.Endpoint;

public class UserDAOPublisher
{
  public static void main(String[] args)
  {
    Endpoint.publish("http://localhost:9999/user", new UserDAOImpl());
  }
}
