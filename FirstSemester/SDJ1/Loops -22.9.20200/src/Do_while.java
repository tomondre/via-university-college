import java.util.Scanner;
public class Do_while
{
  public static void main(String[] args)
  {
    int x,y;
    char z;
    Scanner keyboard= new Scanner(System.in);
    do
    {
    System.out.println("First number:");
    x = keyboard.nextInt();
    System.out.println("First number:");
    y = keyboard.nextInt();
    System.out.println("The sum is: " + (x+y));
    System.out.println("Type y to continue");
    z = keyboard.next().charAt(0);
    }
    while (z == 'y');

  }
}
