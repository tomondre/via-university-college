public class Circle
{
  private double radius;

  public Circle()
  {
    radius = 0;
  }


  private double getArea(){
    return Math.PI * radius * radius;
  }
  private double getRadius(){
    return radius;
  }
  public String toString(){
    return "Radius: " + radius + " Area: " + getArea();
  }
}
