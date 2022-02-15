import java.util.Scanner;
public class pi
{
  public static void main(String[] args)
  {
    double pi = 0;
    double i = 0;
    double x = 3;
    Scanner keyboard = new Scanner(System.in);
    System.out.println("How many iterations?");
    i = keyboard.nextInt();
    for (;i>0;i--)
    {
      pi=pi + -(1/x)+(1/(x+2));
      System.out.println(pi);
      System.out.println(i);
      System.out.println(4*(1+pi));
      x=x+4;
    }
  }
}
