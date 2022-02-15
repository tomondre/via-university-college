package Ex10_5.simpleCalculator.SimpleServer;

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

      out.println("connected");
      while (true)
      {
        try
        {
          out.println("First number");
          double firstValue = Double.parseDouble(in.readLine());

          out.println("Second number");
          double secondValue = Double.parseDouble(in.readLine());

          out.println("Operation");
          char operation = in.readLine().charAt(0);

          double result = 0;
          switch (operation)
          {
            case '+':
              result = firstValue + secondValue;
              break;

            case '*':
              result = firstValue * secondValue;
              break;

            case '-':
              result = firstValue - secondValue;
              break;

            case '/':
              result = firstValue / secondValue;
              break;
          }

          out.println(
              "Result is: " + result + ", continue? y for Yes, n for No");

          char answer = in.readLine().toLowerCase().charAt(0);

          if (answer == 'n')
          {
            out.println("stop");
            break;
          }
        }
        catch (NumberFormatException e)
        {
          out.println("Wrong format");
        }
      }
    }
  }
}

