import java.util.Scanner;
public class Test_book
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("---------Book 1---------");
    System.out.println("Name of the book:");
    String a = keyboard.nextLine();
    System.out.println("Title ");
    String b = keyboard.nextLine();
    System.out.println("Price");
    double c = keyboard.nextDouble();
    c = c*0.8;
    System.out.println("Pages ");
    int d = keyboard.nextInt();
    Book b1 = new Book(a, b, c, d);
    System.out.println(b1);

    System.out.println("---------Book 2---------");
    System.out.println("Name of the book:");
    keyboard.nextLine();
    a = keyboard.nextLine();
    System.out.println("Title ");
    b = keyboard.nextLine();
    System.out.println("Price");
    c = keyboard.nextDouble();
    System.out.println("Pages ");
    d = keyboard.nextInt();
    c = c*0.8;
    Book b2 = new Book(a, b, c, d);

    System.out.println(b1);
    System.out.println(b2);
  }
}