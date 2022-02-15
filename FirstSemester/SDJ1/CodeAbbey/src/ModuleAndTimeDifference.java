import java.util.Scanner;

public class ModuleAndTimeDifference
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int result = 0;
    int[] list = new int[keyboard.nextInt()];
    for (int i = 0; i < list.length; i++)
    {
      list[i] = Math.abs((
          (keyboard.nextInt() * 86400) + (keyboard.nextInt() * 3600) + (
              keyboard.nextInt() * 60) + keyboard.nextInt()) - ((
          (keyboard.nextInt() * 86400) + (keyboard.nextInt() * 3600) + (
              keyboard.nextInt() * 60) + keyboard.nextInt())));
    }
    int d, h, m, s;
    for (int i = 0; i < list.length; i++)
    {
      d = list[i] / 86400;
      h = (list[i] % 86400) / 3600;
      m = (list[i] % 3600) / 60;
      s = list[i] % 60;
      System.out.print("(" + d + " " + h + " " + m + " " + s + ") ");
    }
  }
}
