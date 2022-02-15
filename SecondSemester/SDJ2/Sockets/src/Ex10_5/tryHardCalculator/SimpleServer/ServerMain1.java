package Ex10_5.tryHardCalculator.SimpleServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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
      out.println("Write sequence of numbers and operator, divided with ',' ");

      while (true)
      {
        String formula = in.readLine();

        ArrayList<Double> numbers = new ArrayList<Double>();
        char operator = '!';
        double sum = 0;

        String[] inputValues = formula.replaceAll(" ", "").split(",");
        for (int i = 0; i < inputValues.length; i++)
        {
          try
          {
            double doubleValue = Double.parseDouble(inputValues[i]);
            numbers.add(doubleValue);
          }
          catch (NumberFormatException e)
          {
            operator = inputValues[i].charAt(0);
          }
        }

        sum = numbers.get(0);
        switch (operator)
        {
          case '+':
            for (int i = 1; i < numbers.size(); i++)
            {
              sum += numbers.get(i);
            }
            break;

          case '*':
            for (int i = 1; i < numbers.size(); i++)
            {
              sum *= numbers.get(i);
            }
            break;

          case '-':
            for (int i = 1; i < numbers.size(); i++)
            {
              sum -= numbers.get(i);
            }
            break;

          case '/':
            for (int i = 1; i < numbers.size(); i++)
            {
              sum /= numbers.get(i);
            }
            break;

        }

        out.println(sum);
        out.println(
            "Write sequence of numbers and operator, divided with ',' ");
      }

    }
  }
}
