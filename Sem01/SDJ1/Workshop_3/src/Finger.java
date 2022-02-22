public class Finger
{
  double length, width;

  public Finger(double length, double width)
  {
    this.length = length;
    this.width = width;
  }

  public void setLength(double length)
  {
    this.length = length;
  }

  public void setWidth(double width)
  {
    this.width = width;
  }

  public Finger copy()
  {
    return new Finger(length, width);
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Finger))
    {
      return false;
    }
    Finger other = (Finger) obj;
    return length == other.length && width == other.width;
  }

  public double getLength()
  {
    return length;
  }

  public double getWidth()
  {
    return width;
  }

  @Override public String toString()
  {
    return "Finger{" + "length=" + length + ", width=" + width + '}';
  }

  public static void main(String[] args)
  {

    Finger finger = new Finger(25, 50);
    System.out.println(finger);
  }
}