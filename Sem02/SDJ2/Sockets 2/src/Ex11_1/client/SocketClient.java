package Ex11_1.client;

import Ex11_2.Message;

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
      for (int i = 0; i < 4; i++)
      {
        Message message = (Message) in.readObject();
        System.out.println(message);
        Message name = new Message(keyboard.nextLine());
        out.writeObject(name);
        message = (Message) in.readObject();

        if (message.get().equals("error") || message.get().equals("stop"))
        {
          System.out.println("Socket closed");
          return;
        }
        System.out.println(message);
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      System.out.println("Error, couldn't find server socket".toUpperCase());
    }
  }
}
