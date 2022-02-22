import java.util.ArrayList;
import java.util.Scanner;

public class B
{

  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);

    int[] list = new int[keyboard.nextInt()];
    System.out.println("---");
    for (int i = 0; i < list.length; i++)
    {
      list[i] = keyboard.nextInt();
    }
    for (int i = 0; i < list.length; i++)
    {
      System.out.println(list[i]);
    }
    int a = 0;
    ArrayList<Integer> temp = new ArrayList<Integer>();
    for (int i = 0; i < list.length; i++)
    {
      if (list.length != i + 1)
      {

        for (int j = i; j < list.length; j++)
        {
          if (list[i] < list[j])
          {
            temp.add(j + 1);
            i = j;
            break;
          }
          if (j + 1 == list.length)
          {
            temp.add(i + 1);
          }

        }

      }
      else
      {
        temp.add(i + 1);
      }
    }
    System.out.println("----");
    for (int i = 0; i < temp.size(); i++)
    {
      System.out.println(temp.get(i));
    }
  }

}
