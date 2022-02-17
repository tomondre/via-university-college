package Ex17_4.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class StartRemoteMessageClient
{
  public static void main(String[] args)
      throws RemoteException, NotBoundException
  {
    RemoteMessageClient client = new RemoteMessageClient();
    Scanner scanner = new Scanner(System.in);
    while (true)
    {
      System.out.println("Message> ");
      String input = scanner.nextLine();

      client.sendMessage(input);
    }
  }
}
