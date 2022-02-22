import java.util.Scanner;

public class Triangles
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int init = keyboard.nextInt();
    int a, b, c;
    for (int i = 0; i < init; i++)
    {
      a = keyboard.nextInt();
      b = keyboard.nextInt();
      c = keyboard.nextInt();
      if ((a + b) < c || (a + c) < b || (c + b) < a)
      {
        System.out.println(0+ " ");
      }
      else
      {
        System.out.println(1 + " ");
      }
    }
  }
}
