package Ex11_3.server;

import Ex11_3.Request;
import Ex11_3.RequestType;
import Ex11_3.model.StringModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private StringModel model;

  public ServerSocketHandler(Socket socket)
  {
    this.socket = socket;
  }

  @Override public void run()
  {
    try
    {
      System.out.println(
          "Client connected from " + socket.getInetAddress().getHostAddress()
              + " " + socket.getLocalPort());
      ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

      for (int i = 0; i < 3; i++)
      {
        Object o = in.readObject();
        if (o == null)
        {
          out.writeObject(new Request("error", "error"));
          continue;
        }
        Request request = (Request) o;
        if (request.getRequestType().equals(RequestType.LowerCase.toString()))
        {
          out.writeObject(
              new Request("answer", StringModel.toLowerCase(request.getArg())));
        }
        else if (request.getRequestType()
            .equals(RequestType.UpperCase.toString()))
        {
          out.writeObject(
              new Request("answer", StringModel.toUpperCase(request.getArg())));
        }
      }
      System.out.println("Operation done");
    }
    catch (Exception e)
    {
    }
  }
}
