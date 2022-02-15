import java.util.Scanner;

public class ArrayCounters
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int[] list = new int[keyboard.nextInt()];
    int[] odpoved = new int[keyboard.nextInt()];
    for (int i = 0; i < list.length; i++)
    {
      list[i] = keyboard.nextInt();
    }
    for (int i = 0; i < list.length; i++)
    {
      for (int j = 0; j < odpoved.length; j++)
      {
        if (list[i]==j+1)
        {
          odpoved[j]++;
        }
      }
    }
    for (int i = 0; i < odpoved.length; i++)
    {
      System.out.print(odpoved[i] + " ");
    }
  }
}
