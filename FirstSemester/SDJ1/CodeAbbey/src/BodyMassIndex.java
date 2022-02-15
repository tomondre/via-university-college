import java.util.Scanner;

public class BodyMassIndex
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int iterations = keyboard.nextInt();
    double bmi;
    double a, b;
    for (int i = 0; i < iterations; i++)
    {
      a = keyboard.nextDouble();
      b = keyboard.nextDouble();
      bmi = a / (b*b);
      if (bmi < 18.5)
      {
        System.out.print("under ");
      }
      else if (18.5 <= bmi && bmi < 25.0)
      {
        System.out.print("normal ");
      }
      else if (25<=bmi&&bmi<30)
      {
        System.out.print("over ");
      }

      else if (30<=bmi)
      {
        System.out.print("obese ");
      }
    }
  }
}
