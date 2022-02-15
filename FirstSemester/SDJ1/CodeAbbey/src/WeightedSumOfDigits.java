import java.util.Scanner;

public class WeightedSumOfDigits
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int length = keyboard.nextInt();
    int lengt;
    int number;
    int sum;
    for (int i = 0; i < length; i++)
    {
      sum = 0;
      number = keyboard.nextInt();
      lengt = String.valueOf(number).length();
      for (int j = lengt; j>0 ; j--)
      {
        sum += (number  % 10) * (j);
        number /= 10;
      }
      System.out.print(sum + " ");
    }



  }
}
