package ColourPalette;

public class Colour
{
  private int red, green, blue;

  public Colour(int red, int green, int blue)
  {
    this.red = red;
    this.green = green;
    this.blue = blue;

  }

  public void set(int red, int green, int blue)
  {
    this.red = red;
    this.green = green;
    this.blue = blue;

  }

  public int getRed()
  {
    return red;
  }

  public int getGreen()
  {
    return green;
  }

  public int getBlue()
  {
    return blue;
  }

  public boolean isGray()
  {
    return red == blue && blue == green;
  }

  public void mixWithColour(Colour colour2)
  {
    red = (int) (0.5 * red + 0.5 * colour2.red);
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

  @Override public String toString()
  {
    return "Colour{" + "red=" + red + ", green=" + green + ", blue=" + blue
        + '}';
  }
}
