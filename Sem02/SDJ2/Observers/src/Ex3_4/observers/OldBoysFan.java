package Ex3_4.observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OldBoysFan implements PropertyChangeListener
{

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("Scores") &&
        evt.getNewValue().equals("Old Boys"))
    {
      System.out.println("OldBoysFan: YEA");
    }

    else if (evt.getPropertyName().equals("Scores") &&
        evt.getNewValue().equals("Dream Team"))
    {
      System.out.println("OldBoysFan: BUUU");
    }

    else if (evt.getPropertyName().equals("RoughTackle") &&
        evt.getNewValue().equals("Dream Team"))
    {
      System.out.println("OldBoysFan: Yes!!!");
    }

    else if (evt.getPropertyName().equals("RoughTackle") &&
        evt.getNewValue().equals("Old Boys"))
    {
      System.out.println("OldBoysFan: No!!!");
    }
  }
}

