package Ex11_1.server;

import Ex11_2.Message;

import java.io.*;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;

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

      out.writeObject(new Message("Hello from server. Write your name"));
      Message nameFromClient = (Message) in.readObject();
      out.writeObject(new Message("Hello " + nameFromClient));

      for (int i = 0; i < 3; i++)
      {
        out.writeObject(new Message("Hello from server. Write your string"));
        Message stringFromClient = (Message) in.readObject();

        if (stringFromClient.get().equals("error"))
        {
          System.out.println("Server closing");
          out.writeObject(stringFromClient);
          return;
        }
        else if (stringFromClient.get().equals("stop"))
        {
          System.out.println("Socket stopped");
          out.writeObject(stringFromClient);
          break;
        }

        out.writeObject(new Message("Uppercase: " + stringFromClient.toUpperCase()));
      }
      System.out.println("Operation done");
    }
    catch (Exception e)
    {
    }
  }
}
