import java.util.Scanner;

public class SavingsCalculator
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int irit = keyboard.nextInt();
    double sum = 0;
    double requiredSum;
    double interestRate;
    int count = 0;
    int[] list = new int[irit];
    for (int i = 0; i < irit; i++)
    {
      count = 0;
      sum = keyboard.nextInt();
      requiredSum = keyboard.nextInt();
      interestRate = keyboard.nextInt()*0.01;
      do
      {
        sum += Math.round(sum * interestRate);
        count++;
      }
      while (requiredSum > sum);
      list[i] = count;
    }

    for (int i : list)
    {
      System.out.print(i + " ");
    }
  }
}
