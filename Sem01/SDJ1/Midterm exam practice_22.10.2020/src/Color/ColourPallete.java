package Color;

import java.util.ArrayList;

public class ColourPallete
{
  private int numberOfColors;
  private ArrayList<Colour> colours;

  public ColourPallete(int maxNumberOfColours)
  {
    colours = new ArrayList<Colour>(maxNumberOfColours);
  }

  public int getNumberOfColours()
  {
    return colours.size();
  }

  public void add(Colour colour)
  {
    colours.add(colour.copy());
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
    colours.get(index).mixWith(colour2);
  }




}
