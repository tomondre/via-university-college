package Ex3_5;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BirdWatcher implements PropertyChangeListener
{
  private String name;

  public BirdWatcher(String name)
  {
    this.name = name;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("Sing"))
    {
      System.out.println(name + ": what a beautiful sound");
    }

    else if (evt.getPropertyName().equals("Wing"))
    {
      System.out.println(name + ": what a beautiful bird flying");
    }
  }
}
