import java.util.Scanner;

public class RotateString
{
  public static void main(String[] args)
  {

    Scanner keyboard = new Scanner(System.in);
    String temp;
    int rotate;
    int init = keyboard.nextInt();
    for (int i = 0; i < init; i++)
    {
      rotate = keyboard.nextInt();
      temp = keyboard.nextLine();
      temp = temp.replaceAll(" ", "");
      if (rotate > 0)
      {
        for (int j = 0; j < rotate; j++)
        {
          temp += temp.charAt(0);
          temp = temp.substring(1);

        }
      }
      else
      {
        for (int j = 0; j < Math.abs(rotate); j++)
        {
          temp = temp.charAt(temp.length()-1)+temp;
          temp = temp.substring(0, temp.length()-1);

        }

      }
      System.out.println(temp + " ");
    }
  }
}
