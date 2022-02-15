package Ex3_4.observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DreamTeamFan implements PropertyChangeListener
{

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("Scores") &&
        evt.getNewValue().equals("Dream Team"))
    {
      System.out.println("DreamTeamFan: YEA");
    }

    else if (evt.getPropertyName().equals("Scores") &&
        evt.getNewValue().equals("Old Boys"))
    {
      System.out.println("DreamTeamFan: BUUU");
    }

    else if (evt.getPropertyName().equals("RoughTackle") &&
        evt.getNewValue().equals("Old Boys"))
    {
      System.out.println("DreamTeamFan: Yes!!!");
    }

    else if (evt.getPropertyName().equals("RoughTackle") &&
        evt.getNewValue().equals("Dream Team"))
    {
      System.out.println("DreamTeamFan: No!!!");
    }
  }
}
