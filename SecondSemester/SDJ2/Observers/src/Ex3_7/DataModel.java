package Ex3_7;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class DataModel implements PropertyChangeSubject
{
  PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  private int r;
  private int g;
  private int b;
  private Random ran = new Random();

  public void recalculateData()
  {
    r = ran.nextInt(66);
    g = ran.nextInt(66);
    b = Math.max(0, (100 - (r + g)));
    System.out.println(r + ":" + g + ":" + b);

    propertyChangeSupport.firePropertyChange("r", 0, r);
    propertyChangeSupport.firePropertyChange("g", 0, g);
    propertyChangeSupport.firePropertyChange("b", 0, b);

  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }
}

