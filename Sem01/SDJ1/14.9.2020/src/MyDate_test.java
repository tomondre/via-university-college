import java.util.Scanner;

public class MyDate_test
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    MyDate b = new MyDate(28,10,2000);
    MyDate t = new MyDate(28,10,2000);
b.nextDays(50);
System.out.println(b);




    /*
    System.out.println(b.isEqualTo(t));
    for (int i = 1;!(b.isEqualTo(t));i++)
    {
      b.stepForwardOneDay();
      System.out.println(i);

    }

     */

    /*
    int c = 0;
    Scanner keyboard = new Scanner(System.in);
    System.out.println("First year:");
    int x = keyboard.nextInt();
    System.out.println("Second year:");
    int y = keyboard.nextInt();
    MyDate m = new MyDate(28,10,x);
    for(; x <y;x++ )
    {
      if (m.isLeapYear())
      {
        c++;
      }
      m.setYear(x);
    }
    System.out.println(c);

     */



    /*MyDate m=new MyDate(40,12,20);

    System.out.println(m);
    System.out.println(m.isBefore(25,12,21));
    System.out.println(m.isLeapYear());

    System.out.println(m.numberOfDaysInMonth());
m.stepForwardOneDay();
    System.out.println(m);
    System.out.println(m.numberOfDaysInMonth());

    System.out.println("-----------");
    MyDate m1=new MyDate(24,3,2000);
    MyDate m2=new MyDate(21,3,2005);
    System.out.println(m1.yearsBetween(m2));

     */
  }
}
