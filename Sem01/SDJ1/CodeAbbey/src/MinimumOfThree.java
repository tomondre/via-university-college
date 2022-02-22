import java.util.Scanner;

public class MinimumOfThree
{
  public static void main(String[] args)
  {
    int a;
    int b;
    int c;
    Scanner keyboard = new Scanner(System.in);
    int ire = keyboard.nextInt();
    for (int i = 0; i < ire; i++)
    {
      a = keyboard.nextInt();
      b = keyboard.nextInt();
      c = keyboard.nextInt();

      if (a < b && a < c)
      {
        System.out.print(a + " ");
      }
      else if (b < a && b < c)
      {
        System.out.println(b + " ");
      }
      else if (c < a && c < b)
      {
        System.out.println(c + " ");
      }

    }

  }

}