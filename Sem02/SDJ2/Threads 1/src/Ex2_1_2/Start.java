package Ex2_1_2;

public class Start
{
  public static void main(String[] args)
  {
    Thread first = new Thread(new Hi(10));
    Thread second = new Thread(new Hello(5));
    
    first.start();
    second.start();
  }
}
