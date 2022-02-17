import java.util.Scanner;
public class Uloha_2_03
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Tax");
    double tax = keyboard.nextDouble();

    System.out.print("Prvé číslo ");
    double prve = keyboard.nextDouble();
    System.out.print("Druhé číslo");
    double druhe = keyboard.nextDouble();
    System.out.print("Tretie číslo ");
    double tretie = keyboard.nextDouble();

    tax = tax*0.01;
    System.out.println(prve * tax);
    System.out.println(druhe*tax);
    System.out.println(tretie*tax);
    tax = tax+1;

    System.out.println(prve*tax);
    System.out.println(druhe*tax);
    System.out.println(tretie*tax);
  }
}
