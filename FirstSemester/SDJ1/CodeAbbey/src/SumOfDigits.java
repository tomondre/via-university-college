import java.util.Scanner;

public class SumOfDigits
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int temp = 0;
    int sum = 0;
    int init = keyboard.nextInt();
    int length = 0;
    System.out.println();
    for (int i = 0; i < init; i++)
    {
      sum = 0;
      temp = (keyboard.nextInt() * keyboard.nextInt()) + keyboard.nextInt();
      length = String.valueOf(temp).length();
      for (int j = 0; j < length ; j++)
      {
        sum += temp % 10;
        temp /= 10;
      }
      System.out.print(sum + " ");
    }
  }
}
