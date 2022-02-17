import java.util.Scanner;

public class SortWithIndexes
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int init = keyboard.nextInt();
    int[] list = new int[init];
    int temp;
    int tempNum;
    int[] result = new int[init];
    for (int i = 0; i < init; i++)
    {
      list[i] = keyboard.nextInt();
    }
    temp = -1;
    for (int i = 0; i < list.length; i++)
    {
      temp = i+1;
      for (int j = i+1; j < list.length; j++)
      {
        if(temp<list[j])
        {
          temp = j;
        }
      }
      result[i] = temp;

    }
    for (int i = 0; i < result.length; i++)
    {
      System.out.println(result[i]);
    }
  }
}
