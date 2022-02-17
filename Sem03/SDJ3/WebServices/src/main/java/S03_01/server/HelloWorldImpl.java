package S03_01.server;


@WebService(endpointInterface = "main.java.S03_01.server.HelloWorld")
public class HelloWorldImpl implements HelloWorld
{

  @Override public String getHelloWorldAsString(String name)
  {
    return "Hello World JAX-WS" + name;
  }
}
