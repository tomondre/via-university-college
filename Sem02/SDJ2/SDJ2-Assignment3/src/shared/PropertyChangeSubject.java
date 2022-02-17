package shared;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject
{
  void addPropertyChangeListener(PropertyChangeListener listener);
  void addPropertyChangeListener(String name, PropertyChangeListener listener);
  void removePropertyChangeListener(PropertyChangeListener listener);
}
