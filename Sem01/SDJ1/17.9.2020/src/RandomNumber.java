
import java.util.Random;
import java.util.Scanner;

public class RandomNumber
{
  public static void main(String[] args)
  {
    int a = 11,p=0;
Scanner keyboard = new Scanner(System.in);
Random randomNumbers = new Random();
int n = randomNumbers.nextInt(11);
System.out.println("Guess number");
while (!(a == n))
{
    System.out.println("Write number");
    a = keyboard.nextInt();
    if (a>n)
    {
      System.out.println("Its less");
    }
      if (a<n)
      {
        System.out.println("Its more");
      }
  p++;
  }
    System.out.println("You are right");
    System.out.println("You make it in " + p + ( "guesses"));
}
  }

