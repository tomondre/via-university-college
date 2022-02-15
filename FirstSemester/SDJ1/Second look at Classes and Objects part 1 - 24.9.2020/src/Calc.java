public class Calc
{
  public static double area(double radius) {
    return Math.PI * radius*radius;
  }
  public static double area(double x,double y) {
    return x * y;
  }
  /*
  public static double area(double radius, double height) {
    return 2 * Math.PI * radius*radius+(height*(2*Math.PI*radius));
  }
   */
  public static void main(String[] args)
  {
    System.out.println(area(25));
  }
}

