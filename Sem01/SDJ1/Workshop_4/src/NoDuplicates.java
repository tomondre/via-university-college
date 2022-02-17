import java.util.Scanner;

public class NoDuplicates
{
  public static boolean isInList(int cislo, int[] list)
  {
    for (int x = 0; x < list.length; x++)
    {
      if (cislo == list[x])
      {
        return true;
      }
    }
    return false;
  }

  public static void FindPlace(int temp, int[] list)
  {
    for (int x = 0; x < list.length; x++)
    {
      if (list[x] == 0)
      {
        list[x] = temp;
        break;
      }
    }
  }

  public static void PrintArray(int[] list)
  {
    for (int i = 0; i < list.length; i++)
    {
      System.out.println(list[i]);

    }
  }

  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int[] list = new int[5];
    int temp;
    boolean is = false;
    int i = 0;
    while (i <= 5)
    {

      System.out.println("Write number to array: ");
      temp = keyboard.nextInt();
      if (isInList(temp, list))
      {
        System.out.println("Duplicate ");
        is = false;
      }
      else
      {
        FindPlace(temp, list);
        i++;
      }
      temp = 0;
    }
    PrintArray(list);
  }
}