package Circle;

public class Circle
{
  private double radius;
  private Point point;

  public Circle(double x, double y, double radius)
  {
    point = new Point(x, y);
    this.radius = radius;
  }

  public Point getCenter()
  {
    return point.copy();
  }

  public double getRadius()
  {
    return radius;
  }

  public void moveCircle(double dx, double dy)
  {
    point.move(dx, dy);
  }

  public double getArea()
  {
    return radius * radius * Math.PI;
  }

  public String toString()
  {
    return "Radius: " + radius + " Center: X: " + point.getX() + " Y: " + point
        .getY();
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Circle))
    {
      return false;
    }
    Circle other = (Circle) obj;
    return point.equals(other.point) && radius == other.radius;
  }
}
