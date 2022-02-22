import java.util.Arrays;
import java.util.Scanner;

public class MedianOfThree
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int init = keyboard.nextInt();
    int[] list = new int[3];
    for (int i = 0; i < init; i++)
    {
      for (int j = 0; j < list.length; j++)
      {
        list[j] = keyboard.nextInt();
      }
      Arrays.sort(list);
      System.out.println(list.length % 2 == 0 ?
          list[list.length / 2 - 1] + " " + list[list.length / 2] + " " :
          list[list.length / 2] + " ");
    }
  }

}
