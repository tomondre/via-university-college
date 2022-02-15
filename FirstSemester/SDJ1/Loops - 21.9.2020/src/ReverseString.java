import java.util.Scanner;
public class ReverseString
{
  public static void main(String[] args)
  {
    String q = "";
    Scanner keyboard = new Scanner(System.in);
    while(!(q.equals("quit")))
    {
      System.out.println("Write String");
      String a = keyboard.nextLine();
      for (int i = a.length() - 1; i >= 0; i--)
      {
        System.out.println(a.charAt(i));
      }
      System.out.println("Type quit if you want to stop");
      q = keyboard.nextLine();
    }
  }
}
