package S03_01.server;

@WebService
@SOAPBinding(style = Style.RPC)
public interface HelloWorld{

  @WebMethod String getHelloWorldAsString(String name);
}