import java.util.Scanner;

public class CollatzSequence
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int result = 0;
    int[] list = new int[keyboard.nextInt()];
    for (int i = 0; i < list.length; i++)
    {
      list[i] = keyboard.nextInt();
    }
    for (int i = 0; i < list.length; i++)
    {
      result = 0;
      while (list[i] != 1)
      {
        if (list[i] % 2 == 0)
        {
          list[i] /= 2;
        }
        else
        {
          list[i] = 3 * list[i] + 1;
        }
        result++;
      }
      System.out.print(result + " ");
    }
  }
}
