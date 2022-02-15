import java.util.Scanner;

public class SquareRoot
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);

    double number = 0;
    double r = 0;
    double x;
    double irit2;
    double irit = keyboard.nextInt();
    for (int i = 0; i < irit; i++)
    {
      number = keyboard.nextInt();
      x = number;
      irit2 = keyboard.nextInt();
      r = 1;
      for (int j = 0; j < r; j++)
      {
        r = (r+(x/r))/2;
      }
      System.out.println(r + " ");
    }

  }
}
