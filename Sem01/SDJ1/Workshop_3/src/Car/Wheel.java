package Car;

public class Wheel
{
  private int diameter, width;
  public Wheel(int diameter, int width)
  {
    this.diameter = diameter;
    this.width = width;
  }
  public int getDiameter()
  {
    return diameter;
  }
  public int getWidth()
  {
    return width;
  }
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Wheel))
    {
      return false;
    }
    Wheel other = (Wheel) obj;
    return diameter == other.diameter&&width==other.width;
  }
  @Override public String toString()
  {
    return "diameter: " + diameter + " width: " + width;
  }
  public Wheel copy(){
    return new Wheel(diameter,width);
  }
}
