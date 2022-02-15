package S03_01.server;


public class HelloWorldPublisher
{
  public static void main(String[] args)
  {
    Endpoint.publish("http://localhost:9999/hello", new HelloWorldImpl());
  }
}
