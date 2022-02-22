import java.util.Scanner;
public class exercise_1
{
  public static void main(String[] args)
  {
    int x,y,z;
    double a,b,c;
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Type an integer:");
x = keyboard.nextInt();
    System.out.println("Type an integer:");
    y = keyboard.nextInt();
    System.out.println("Type an integer:");
    z = keyboard.nextInt();
    System.out.println("The product of "+ (x* y));
    System.out.println("The sum of "+ (x + y));
    b = y;
    c = z;
    a = b / c;
    System.out.println("The quotient of "+ a);

    System.out.println("The difference of "+ (y - z));







  }
}
