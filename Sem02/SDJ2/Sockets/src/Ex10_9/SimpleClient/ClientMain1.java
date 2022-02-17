package Ex10_9.SimpleClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain1
{

  public static void main(String[] args) throws IOException
  {
    Socket socket = new Socket("127.0.0.1", 1235);

    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));

    Scanner keyboard = new Scanner(System.in);

    System.out.println("WELCOME TO CHAT");

    while (true)
    {
      String action = keyboard.nextLine();

      out.println(action);

      if(action.equals("Stop"))
      {
        break;
      }

      System.out.println(in.readLine());

      out.println(keyboard.nextLine());

      System.out.println("Result: " + in.readLine());

    }
  }
}
