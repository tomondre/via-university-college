package Color;

public class Colour
{
  private double red,green, blue;
  
  public Colour(double red, double green, double blue)
  {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }
  public void set(double red, double green, double blue)
  {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }
  public double getRed()
  {
    return red;
  }
  public double getGreen()
  {
    return green;
  }
  public double getBlue()
  {
    return blue;
  }
  public boolean isGray()
  {
    if (red==green&&green==blue)
    {
      return true;
    }
    else return false;
  }
  public void mixWith(Colour colour2)
  {
    red = (red*0.5) + (colour2.red * 0.5);
  }
  public Colour copy()
  {
    return new Colour(red, green, blue);
  }
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Colour))
    {
      return false;
    }
  Colour other = (Colour)obj;
  return red==other.red&&green==other.green&&blue==other.blue;
  }

}
