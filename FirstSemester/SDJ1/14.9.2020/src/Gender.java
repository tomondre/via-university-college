import  java.util.Scanner;
public class Gender
{
  public static void main(String[] args)
  {
    String s;
    char c;
    int age;
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Napis char");
    s = keyboard.nextLine();
    System.out.println("Napis vek");
    age = keyboard.nextInt();
    c = s.charAt(0);
    if (c!= 'M'&&c!= 'F'|| age < 0)
    {
      System.out.println("Error");
    }
   if (c == 'M' && age < 18)
 {
  System.out.println("Boy");
}
    if (c == 'M' && age >= 18)
    {
      System.out.println("Man");
    }
    if (c == 'F' && age < 18)
    {
      System.out.println("Girl");
    }
    if (c == 'F' && age >= 18)
    {
      System.out.println("Woman");
    }
  }
}
