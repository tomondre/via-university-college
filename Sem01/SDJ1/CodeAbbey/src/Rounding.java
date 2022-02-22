import java.util.Scanner;

public class Rounding
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int init = keyboard.nextInt();
    for (int i = 0; i < init; i++)
    {
      System.out
          .print(Math.round(keyboard.nextDouble() / keyboard.nextDouble()) + " ");
    }
  }
}
