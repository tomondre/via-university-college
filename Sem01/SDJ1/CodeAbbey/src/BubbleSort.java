import java.util.Scanner;

public class BubbleSort
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    boolean sorted = true;
    int[] list = new int[keyboard.nextInt()];
    int temp;
    int number = 0;
    int pass = 0;
    for (int i = 0; i < list.length; i++)
    {
      list[i] = keyboard.nextInt();
    }
    while (sorted)
    {
      sorted = false;
      for (int i = 0; i < list.length; i++)
      {
        if (i!=list.length-1)
        {
          if (list[i] > list[i + 1])
          {
            temp = list[i];
            list[i] = list[i + 1];
            list[i + 1] = temp;
            sorted = true;
            number++;
          }
        }
      }

      pass++;
    }
    System.out.println(pass + " " + number);

  }

}
