package S03_01.client;


import javax.xml.namespace.QName;
import java.net.URL;

public class HelloWorldClient
{
  public static void main(String[] args) throws Exception
  {
    URL url = new URL("http://localhost:9999/hello?wsdl");
    QName qname = new QName("http://server.S03_01.java.main/", "HelloWorldImplService");
    Service service = Service.create(url, qname);
    HelloWorld helloWorld = service.getPort(HelloWorld.class);
    System.out.println(helloWorld.getHelloWorldAsString("Halbalsa"));
  }
}
