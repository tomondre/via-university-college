import java.util.Scanner;

public class LinearFunction
{

  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int result = 0;
    int arr = keyboard.nextInt();
    int[][] list = new int[arr][arr];
    for (int i = 0; i < list.length; i++)
    {
      list[i][0] = keyboard.nextInt();
      list[i][1] = keyboard.nextInt();
    }
    System.out.println();
  }
}
