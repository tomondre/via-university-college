package Ex10_7.SimpleServer;

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
      String client = socket.getInetAddress().getCanonicalHostName();
      System.out.println(
          "Client connected from " + socket.getInetAddress().getHostAddress()
              + " " + socket.getLocalPort());
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));

      String action = in.readLine();
      System.out.println("Received: " + action);

      if (!action.equals("connect"))
      {
        out.println("Disconnected");
        System.out.println("Invalid action");
        continue;
      }

      out.println("Username?");
      System.out.println("Sent: Username?" + ", from Client: " + client);
      String username = in.readLine();
      System.out.println("Received username: " + username+ ", from Client: " + client);

      out.println("Password?");
      System.out.println("Sent: Password?" + ", from Client: " + client);
      String password = in.readLine();
      System.out.println("Received: " + password + ", from Client: " + client);

      out.println("Approved");
      System.out.println("Login approved"+ ", to Client: " + client);
    }
  }
}

