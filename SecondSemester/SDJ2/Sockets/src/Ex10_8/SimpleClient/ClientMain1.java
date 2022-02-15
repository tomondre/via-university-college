package Ex10_8.SimpleClient;

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

    while (true)
    {
      out.println("Client: " + keyboard.nextLine());
      System.out.println(in.readLine());
    }
  }
}
