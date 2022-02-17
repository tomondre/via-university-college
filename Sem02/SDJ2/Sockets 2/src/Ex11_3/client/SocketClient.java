package Ex11_3.client;

import Ex11_3.Request;
import Ex11_3.RequestType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient
{

  public void start()
  {
    try
    {
      Socket socket = new Socket("localhost", 1234);

      ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

      Scanner keyboard = new Scanner(System.in);

      //The protocol for showing name + protocol for displaying toString() method so 1+3
      for (int i = 0; i < 3; i++)
      {
        System.out.println(
            "Make Request: [arg:String] , [msg:String] \n Arg can be: "
                + RequestType.LowerCase + " or " + RequestType.UpperCase);
        String arg = keyboard.nextLine();
        if (arg.equals(RequestType.LowerCase.toString()) || arg
            .equals(RequestType.UpperCase.toString()))
        {
          Request request = new Request(arg, keyboard.nextLine());
          out.writeObject(request);
        }
        else {
          out.writeObject(null);
        continue;
        }
        Request answer = (Request) in.readObject();
        System.out.println(answer.getArg());
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      System.out.println("Error, couldn't find server socket".toUpperCase());
    }
  }
}