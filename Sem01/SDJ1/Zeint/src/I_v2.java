import java.util.Scanner;

public class I_v2
{
  public static void main(String[] args)
  {

    Scanner keyboard = new Scanner(System.in);
    int number = keyboard.nextInt();
    int divisor = keyboard.nextInt();
    int temp = number;

    temp -= number % 10;
    for (int i = 0; i < 10; i++)
    {
      temp+=1;
      if (temp % divisor == 0)
      {
        System.out.println(temp);
        break;
      }
    }

  }
}
