import java.util.Scanner;

public class I
{

  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int number = keyboard.nextInt();
    int delitel = keyboard.nextInt();
    boolean done = false;
    int dif = 1;
    int temp = number;
    if (number % delitel == 0)
    {
      System.out.println("0");
    }
    else
    {
      temp = number - (number % (dif * 10));
      while (!done)
      {
        for (int i = 0; i < 10; i++)
        {
          if (temp % delitel == 0)
          {
            done = true;
            System.out.println(temp);
            break;
          }

          temp += dif;
        }
        if (done)
        {
          break;
        }
        temp = number;
        dif *= 10;

        temp = (temp - number % (dif * 10)) + number % dif;

      }
    }
  }
}
