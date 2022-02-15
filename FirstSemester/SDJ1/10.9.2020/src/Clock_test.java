public class Clock_test
{
  public static void main(String[] args)
  {
    Clock c1  = new Clock(36000);
    Clock c2  = new Clock(5,55,15);
    System.out.println(c1);
    System.out.println(c2);
System.out.println(c2.isBefore(c1));



  }



}
