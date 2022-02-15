public class TestClock
{
  public static void main(String[] args)
  {
    Clock c1 = new Clock(360000);
  c1.setTimeFormat(12);
    Clock c2 = new Clock(100);
    System.out.println(c1);
System.out.println(c1.convertToSeconds());
System.out.println(c1.isBefore(c2));
  }
}
