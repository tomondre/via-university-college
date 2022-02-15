import java.util.Scanner;
public class Multiplied_by_2
{
  public static void main(String[] args)
  {
    int product;
    Scanner keyboard=new Scanner(System.in);
    System.out.println("Write number");
    product = keyboard.nextInt();
    while (product<100)
    {
      product = product*10;
    }
    System.out.println(product);
  }
}
