package Line;

public class Line
{
  private String color;
  private Point pointA;
  private Point pointB;
  public Line(Point pointA, Point pointB,String color)
  {
    this.color = color;
    this.pointA = pointA;
    this.pointB = pointB;
  }
  public Line(Point pointA, Point pointB)
  {
    this.pointA = pointA;
    this.pointB = pointB;
  }
  public void setColor(String color)
  {
    this.color = color;
  }
  public void setPointA(Point pointA)
  {
    this.pointA = pointA;
  }
  public void setPointB(Point pointB)
  {
    this.pointB = pointB;
  }
  public String getColor()
  {
    return color;
  }
  public Point getPointA()
  {
    return pointA;
  }
  public Point getPointB()
  {
    return pointB;
  }
  public double getLenght(){
    return pointB.getX()-pointA.getX();
  }
}
