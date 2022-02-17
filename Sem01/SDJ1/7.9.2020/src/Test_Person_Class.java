import java.util.Scanner;
public class Test_Person_Class
{
  public static void main(String[] args)
  {
     System.out.println();
     Scanner keyboard = new Scanner(System.in);
     Person p1 = new Person("Peter","28.10.2000");
     Person p2 = new Person();

     /*System.out.println("Napis meno");
     p1.setName(keyboard.nextLine());
     System.out.println("Napis narodeniny");
     p1.setBirthday(keyboard.nextLine());
     System.out.println("Name p1: " + p1.getName());
     System.out.println("Birthday p1: " + p1.getBirthday());

    System.out.println("Napis meno");
    p2.setName(keyboard.nextLine());
    System.out.println("Napis narodeniny");
    p2.setBirthday(keyboard.nextLine());
    System.out.println("Name p2: " + p2.getName());
    //System.out.println("Birthday p2: " + p2.getBirthday());
    System.out.println("Name p1: " + p1.getName());*/
    System.out.println(p1);
  }

}
