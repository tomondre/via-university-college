package Ex10_5.simpleCalculator.SimpleClient;

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

    String initMessage = in.readLine();
    if (initMessage.equals("connected"))
    {
      System.out.println("Connected successfully");
    }
    else
    {
      return;
    }
    Scanner scanner = new Scanner(System.in);

    while (true)
    {
      String message = in.readLine();
      if (message.equals("stop"))
      {
        return;
      }
      else if (message.equals("Wrong format"))
      {
        System.out.println("Wrong format exception");
        continue;
      }
      System.out.println(message);

      String input = scanner.nextLine();
      out.println(input);

    }
  }
}

