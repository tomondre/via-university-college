package model;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject
{
  void addListener(PropertyChangeListener listener);
  void firePropertyChange(String propertyName, int thermometerID,
      double newValue);

}
