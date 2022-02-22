import java.util.Scanner;
public class Grade
{
  public static void main(String[] args)
  {
    Scanner keyboard=new Scanner(System.in);
    int g;
    System.out.println("Write grade");
    g = keyboard.nextInt();
    if (g == 12)
    {
      System.out.println("A");
    }
    else if (g == 10)
    {
      System.out.println("B");
    }
    else if (g == 7)
    {
      System.out.println("C");
    }
    else if (g == 4)
    {
      System.out.println("D");
    }
    else if (g == 2)
    {
      System.out.println("E");
    }
    else if (g == 0)
    {
      System.out.println("Fx");
    }
   else if (g == -3)
    {
      System.out.println("F");
    }
   else
    {
      System.out.println("Error");
    }
  }
}
