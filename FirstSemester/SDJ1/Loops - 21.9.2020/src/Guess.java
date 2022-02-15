import java.util.Random;
import java.util.Scanner;
public class Guess
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    Random rand = new Random();
    int r = rand.nextInt(100);
    int g;
    boolean c = false;
    System.out.println("Guess a number");
    for (int i = 0; !c; i++)
    {
      g = keyboard.nextInt();
      if (r==g)
      {
        System.out.println("You guessed the number in " + i + ( " guesses"));
        c = true;
      }
      else if (r>g)
      {
        System.out.println("Number is bigger");
      }
      else {System.out.println("Number is smaller");}
    }
  }
}
