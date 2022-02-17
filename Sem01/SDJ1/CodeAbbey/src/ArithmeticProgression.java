import java.util.Scanner;

public class ArithmeticProgression
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int length = keyboard.nextInt();
    int a, b, c;
    int sum = 0;
    for (int i = 0; i < length; i++)
    {
      sum = 0;
      a = keyboard.nextInt();
      b = keyboard.nextInt();
      c = keyboard.nextInt();
      for (int j = 0; j < c; j++)
      {
        sum += a + (j * b);
      }
      System.out.println(sum + " ");
    }

  }
}
