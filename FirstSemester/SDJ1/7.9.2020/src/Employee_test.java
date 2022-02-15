import java.util.Scanner;
public class Employee_test
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    Employee e1 = new Employee();
    Employee e2 = new Employee();

    System.out.println("---------Person 1---------");
    System.out.println("Name");
    e1.setName(keyboard.nextLine());
    System.out.println("Id");
    e1.setId(keyboard.nextInt());
    System.out.println("Position");
    keyboard.nextLine();
    e1.setPosition(keyboard.nextLine());
    System.out.println("Department");
    e1.setDepartment(keyboard.nextLine());

    System.out.print("name: " + e1.getName());
    System.out.print("      ID: " + e1.getId());
    System.out.print("      Position: " + e1.getPosition());
    System.out.println("      Department: " + e1.getDepartment());


    System.out.println("---------Person 2---------");
    System.out.println("Name");
    e2.setName(keyboard.nextLine());
    System.out.println("Id");
    e2.setId(keyboard.nextInt());
    System.out.println("Position");
    keyboard.nextLine();
    e2.setPosition(keyboard.nextLine());
    System.out.println("Department");
    e2.setDepartment(keyboard.nextLine());

    System.out.print("name: " + e2.getName());
    System.out.print("      ID: " + e2.getId());
    System.out.print("      Position: " + e2.getPosition());
    System.out.println("      Department: " + e2.getDepartment());

    System.out.print("name: " + e1.getName());
    System.out.print("      ID: " + e1.getId());
    System.out.print("      Position: " + e1.getPosition());
    System.out.println("      Department: " + e1.getDepartment());
  }
}
