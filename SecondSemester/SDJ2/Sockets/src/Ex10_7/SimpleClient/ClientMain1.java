package Ex10_7.SimpleClient;

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

    Scanner scanner = new Scanner(System.in);

    out.println(scanner.nextLine());


    String answer = in.readLine();
    if (answer.equals("Disconnected"))
    {
      System.out.println(answer);
      return;
    }

    System.out.println(answer);
    out.println(scanner.nextLine());

    System.out.println(in.readLine());
    out.println(scanner.nextLine());

    System.out.println(in.readLine());
  }
}

