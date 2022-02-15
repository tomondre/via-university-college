package Ex22_2;

import Ex22_2.server.core.ModelFactory;
import Ex22_2.server.core.ServerFactory;

import java.io.IOException;

public class RunServer
{
  public static void main(String[] args) throws IOException
  {

    System.out.println(".....Initializing......");
    ModelFactory model = new ModelFactory();
    ServerFactory server = new ServerFactory(model);

    System.out.println("Server started successfully");
    server.start();
  }
}
