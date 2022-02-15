import java.util.Scanner;

public class FahrenheitToCelsius
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int init = keyboard.nextInt();
    for (int i = 0; i < init; i++)
    {
      System.out.print(Math.round((keyboard.nextInt()-32) / 1.8) + " ");
    }
  }
}
