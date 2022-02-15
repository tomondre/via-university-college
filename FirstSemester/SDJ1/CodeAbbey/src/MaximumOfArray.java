import java.util.Scanner;

public class MaximumOfArray
{
  public static void main(String[] args)
  {
    Scanner keyword = new Scanner(System.in);

    int[] list = new int[300];
    for (int i = 0; i < list.length; i++)
    {
      list[i] = keyword.nextInt();
    }
    int temp = list[0];
    for (int i = 0; i < list.length; i++)
    {
      if (temp < list[i])
      {
        temp = list[i];
      }
    }
    System.out.print(temp + " ");
    for (int i = 0; i < list.length; i++)
    {
      if (temp > list[i])
      {
        temp = list[i];
      }
    }
    System.out.print(temp);
  }
}
