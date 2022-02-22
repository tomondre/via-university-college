import java.util.Scanner;
public class Payroll_test
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    Payroll p1 = new Payroll();
    Payroll p2 = new Payroll();

    System.out.println("---------Person 1---------");
    System.out.println("Name");
    p1.setName(keyboard.nextLine());
    System.out.println("Rate");
    p1.setRate(keyboard.nextInt());
    System.out.println("Hours");
    p1.setHours(keyboard.nextInt());

    System.out.println("name: " + p1.getName());
    System.out.println("Rate: " + p1.getRate());
    System.out.println("hours: " + p1.getHours());
    System.out.print("Salary: ");
    System.out.println(p1.getHours() * p1.getRate());

    System.out.println("---------Person 2---------");
    keyboard.nextLine();
    System.out.println("Name");

    p2.setName(keyboard.nextLine());
    System.out.println("Rate");
    p2.setRate(keyboard.nextInt());
    System.out.println("Hours");
    p2.setHours(keyboard.nextInt());

    System.out.println("name2: " + p2.getName());
    System.out.println("Rate2: " + p2.getRate());
    System.out.println("hours2: " + p2.getHours());
    System.out.print("Salary: ");
    System.out.println(p2.getHours() * p2.getRate());
  }
}
