public class Car_test
{
  public static void main(String[] args)
  {
    Car c1 = new Car(2009, "slovakia", 10);
    System.out.println(c1);
    c1.Accelerate();
    System.out.println(c1);
    c1.Brake();
    System.out.println(c1);
  }
}