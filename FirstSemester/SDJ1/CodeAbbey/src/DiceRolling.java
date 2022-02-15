import java.util.Scanner;

public class DiceRolling
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
int length = keyboard.nextInt();
    for (int i = 0; i < length; i++)
    {
      System.out.print(((int)(keyboard.nextFloat()*6) + 1) + " ");
    }

  }
}
