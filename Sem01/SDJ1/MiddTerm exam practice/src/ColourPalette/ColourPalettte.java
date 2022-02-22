package ColourPalette;

import java.util.ArrayList;

public class ColourPalettte
{
  private int numberOfColours;
  private ArrayList<Colour> colours;

  public ColourPalettte(int maxNumberOfColours)
  {
    colours = new ArrayList<Colour>(maxNumberOfColours);
  }

  public int getNumberOfColours()
  {
    return colours.size();
  }

  public void add(Colour colour)
  {
    colours.add(colour);
  }

  public Colour get(int index)
  {
    return colours.get(index);
  }

  public int getNumberOfGrayColours()
  {
    int temp = 0;
    for (int i = 0; i < colours.size(); i++)
    {
      if (colours.get(i).isGray())
      {
        temp++;
      }
    }
    return temp;
  }

  public void mixColour(int index, Colour colour2)
  {
    colours.get(index).mixWithColour(colour2);
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof ColourPalettte))
    {
      return false;
    }
    ColourPalettte other = (ColourPalettte) obj;
    return numberOfColours == other.numberOfColours && colours
        .equals(other.colours);
  }

  @Override public String toString()
  {
    return "ColourPalettte{" + "numberOfColours=" + numberOfColours
        + ", colours=" + colours + '}';
  }
}
