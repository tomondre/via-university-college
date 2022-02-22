package Line;

public class Point
{
  private double x,y;
  public Point(double x, double y)
  {
    this.x = x;
    this.y = y;
  }
  public double getX()
  {
    return x;
  }
  public double getY()
  {
    return y;
  }
  public void moveTo(double x, double y){
    this.x = x;
    this.y = y;
  }
  public void move(double xDistance, double yDistance){
    x+=xDistance;
    y+=yDistance;
  }
  public Point copy(){
    return new Point(x,y);
  }
  @Override public String toString()
  {
    return "Point{" + "x=" + x + ", y=" + y + '}';
  }
  public boolean equals(Object obj){
    if (!(obj instanceof Point)){return false;}
  Point other = (Point)obj;
    return x== other.x&&y==other.y;
  }

}
