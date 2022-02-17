import java.util.Scanner;

public class AvarageOfAnArray
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);

    boolean done = false;
    int temp = 0;
    int sum = 0;
    int number = 0;
    int length = keyboard.nextInt();
    for (int i = 0; i < length; i++)
    {
      done = false;
      number = 0;
      sum = 0;

      while (!done)
      {
        temp = keyboard.nextInt();
        if (temp != 0)
        {
          number++;
          sum += temp;
          temp = 0;
        }
        else
        {
          done = true;
          System.out.println(Math.round((double)sum / number) + " ");
        }

      }

    }
  }

}
