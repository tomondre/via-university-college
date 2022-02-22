import java.util.ArrayList;
import java.util.Scanner;

public class RockPaperScissors
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    ArrayList<String> games = new ArrayList<String>();
    int p1 = 0;
    int p2 = 0;
    int count = keyboard.nextInt();
    String input;
    String[] temp;
    for (int i = 0; i < count + 1; i++)
    {
      input = keyboard.nextLine();
      temp = input.split(" ");
      for (String elem : temp)
      {
        games.add(elem);
      }
      for (int j = 0; j < games.size(); j++)
      {
        if (temp[j].length()>0)
        {

          if (temp[j].charAt(0) == 'R')
          {
            if (temp[j].charAt(1) == 'P')
            {
              p2++;
            }
            else
            {
              p1++;
            }
          }
          else if (temp[j].charAt(0) == 'P')
          {
            if (temp[j].charAt(1) == 'R')
            {
              p1++;
            }
            else
            {
              p2++;
            }
          }
          else if (temp[j].charAt(0) == 'S')
          {
            if (temp[j].charAt(1) == 'P')
            {
              p1++;
            }
            else
            {
              p2++;
            }
          }
        }
      }
      System.out.print(p1 > p2 ? "1 " : "2 ");
      games = new ArrayList<String>();

      p1 = 0;
      p2 = 0;
    }
  }
}
