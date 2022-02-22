import java.util.Scanner;

public class G
{
  public static int output(Scanner keyboard)
  {
    int[] list = new int[keyboard.nextInt()];

    for (int j = 0; j < list.length; j++)
    {
      list[j] = keyboard.nextInt();
    }
    int temp = 0;
    int[] tempList = new int[list.length - 1];
    for (int j = 0; j < tempList.length; j++)
    {
      for (int k = 0; k <= j + 1; k++)
      {
        tempList[j] += list[k];
      }
      temp += tempList[j];
    }

    return temp;
  }

  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int numberOfArrays = keyboard.nextInt();
    int[] results = new int[numberOfArrays];
    for (int i = 0; i < numberOfArrays; i++)
    {
      results[i] = output(keyboard);
    }
    for (int i = 0; i < results.length; i++)
    {
      System.out.println(results[i]);
    }
  }
}
