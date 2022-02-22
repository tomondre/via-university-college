import java.util.Scanner;

public class SumInLoop
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int[] list  = new int[keyboard.nextInt()];
    for (int i = 0; i < list.length; i++)
    {
      list[i] =  keyboard.nextInt();
    }
    int sum = 0;
    for (int i = 0; i < list.length; i++)
    {
      sum+=list[i];
    }
    System.out.println(sum);
  }
}
