import java.util.Scanner;

public class Input_n
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Write number");
    int a = keyboard.nextInt();
    for(int i=1; i<=a; i++)
    {
      System.out.print(i);
    }
    System.out.println();
    for(int i=2; i<=(2*a); i = i + 2)
    {
      System.out.print(i);
    }
    System.out.println();
    for(int i = 1;i <=a;i++)
    {
      System.out.println(i*i+ " ");
    }
  }
}
