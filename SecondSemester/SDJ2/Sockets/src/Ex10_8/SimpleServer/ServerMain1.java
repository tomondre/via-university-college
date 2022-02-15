package Ex10_8.SimpleServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain1
{

  public static void main(String[] args) throws IOException
  {
    ServerSocket serverSocket = new ServerSocket(1235);

    while (true)
    {
      Socket socket = serverSocket.accept();
      System.out.println(
          "Client connected from " + socket.getInetAddress().getHostAddress()
              + " " + socket.getLocalPort());
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));

      out.println("How can I help you?");
      while (true)
      {
        String action = in.readLine();

        if (action.equals("Stop"))
        {
          socket.close();
          break;
        }

        out.println("Argument?");

        String argument = in.readLine();

        if (action.equals("upper case"))
        {
          out.println(argument.toUpperCase());
        }

        else if (action.equals("lower case"))
        {
          out.println(argument.toLowerCase());
        }
        else {
          break;
        }
      }

      System.out.println("Operation done");
    }
  }

}
