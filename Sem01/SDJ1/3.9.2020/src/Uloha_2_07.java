import java.util.Scanner;
public class Uloha_2_07
{
  public static void main(String[] args)
  {
    System.out.println("----------BUYING----------");
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Number of bought shares? ");
    double a = keyboard.nextDouble();

    System.out.println("Cost of one share? ");
    double b = keyboard.nextDouble();

    System.out.println("Commision of your stockbroker? ");
    int c = keyboard.nextInt();

    System.out.println("----------SELLING----------");

    System.out.println("Number of sold shares? ");
    double d = keyboard.nextDouble();

    System.out.println("Cost of one share? ");
    double e = keyboard.nextDouble();

    System.out.println("Commision of your stockbroker? ");
    int f = keyboard.nextInt();


    double g = a * b;
    System.out.println("You have paid " + g + " for the stock");

    double h = g * (c*0.01);
    System.out.println("You have paid " + h + " to your broker when buying");

    double i =d*e;
    System.out.println("You have sold your stocks for " + i);

    double j = i * (f*0.01);
    System.out.println("You have paid " + j + " to your broker when selling");

    double k = (i - j) - (g - h);
    System.out.println("You have made " + k + " profit");
  }
}
