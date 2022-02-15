import java.util.Scanner;

public class VowelCount
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    String temp;
    int occ = 0;
    int init = keyboard.nextInt();
    keyboard.nextLine();
    for (int i = 0; i < init; i++)
    {
      occ = 0;
      temp = keyboard.nextLine();
      for (int j = 0; j < temp.length(); j++)
      {
        if (temp.charAt(j) == 'a' || temp.charAt(j) == 'o'
            || temp.charAt(j) == 'u' || temp.charAt(j) == 'i'
            || temp.charAt(j) == 'e' || temp.charAt(j) == 'y')
        {
          occ++;
        }
      }
      System.out.println(occ + " ");
    }
  }
}
