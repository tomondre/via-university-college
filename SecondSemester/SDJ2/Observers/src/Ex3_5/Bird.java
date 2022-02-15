package Ex3_5;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Bird implements PropertyChangeSubject
{
  PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  private String name;

  public Bird(String name)
  {
    this.name = name;
  }

  public void start(int iterations)
  {
    int num;
    int max = 100;
    for (int i = 0; i < iterations; i++)
    {
      num = (int) (Math.random() * max);

      if (num < max/2)
      {
        System.out.println( name + " sings");
        propertyChangeSupport.firePropertyChange("Sing", -1, 0);
      }

      else
      {
        System.out.println( name + " wings");
        propertyChangeSupport.firePropertyChange("Wing", -1, 0);
      }

      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
      }
    }
  }

  @Override public void addPropertyListener(PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }
}
