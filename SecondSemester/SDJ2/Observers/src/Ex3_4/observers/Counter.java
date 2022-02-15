package Ex3_4.observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Counter implements PropertyChangeListener
{
  private int team0 = 0;
  private int team1 = 0;

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("Scores") &&
        evt.getNewValue().equals("Dream Team"))
    {
    team0++;
    showGoalsInfo();
    }

    else if (evt.getPropertyName().equals("Scores") &&
        evt.getNewValue().equals("Old Boys"))
    {
    team1++;
    showGoalsInfo();
    }

    else if (evt.getPropertyName().equals("End"))
    {
      showGoalsInfo();
    }

  }

  public void showGoalsInfo()
  {
    System.out.println(team0 + ":" + team1);
  }
}
