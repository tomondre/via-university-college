import java.util.Scanner;

public class ArrayChecksum
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int result = 0;
    int[] list = new int[keyboard.nextInt()];
    for (int i = 0; i < list.length; i++)
    {
      list[i] = keyboard.nextInt();
    }
    for (int i = 0; i < list.length; i++)
    {
      result = ((result + list[i]) * 113)% 10000007;
    }
    System.out.println(result);
  }
}
