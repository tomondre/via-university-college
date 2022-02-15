import java.util.Scanner;

public class MinimumOfTwo
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int number  = keyboard.nextInt();
    int[] list1 = new int[number];
    int[] list2 = new int[number];
    for (int i = 0; i < number; i++)
    {
      list1[i] = keyboard.nextInt();
      list2[i] = keyboard.nextInt();
    }
    for (int i = 0; i < number; i++)
    {
      System.out.print((list1[i]<list2[i]?list1[i]:list2[i]) + " ");
    }

  }

}
