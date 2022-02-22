import java.util.Scanner;

public class ReverseString
{
  public static void main(String[] args)
  {
Scanner keyboard = new Scanner(System.in);
    String string = keyboard.nextLine();
    for (int i = string.length()-1; i >=0 ; i--)
    {
      System.out.print(string.charAt(i));
    }
  }
}
