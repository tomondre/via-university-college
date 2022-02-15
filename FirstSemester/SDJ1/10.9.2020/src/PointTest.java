import java.awt.*;

public class PointTest
{
  public static void main(String[] args)
  {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(10, 10);
    System.out.println(p1);
    p1.move(10, 10);
    System.out.println(p1);
    System.out.println(Math.sqrt(Math.pow(p2.getX() - p1.getX(),2) + Math.pow(p2.getY() - p1.getY(),2)));
  }
}
