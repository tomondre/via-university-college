package Ex.model;

import java.beans.PropertyChangeListener;

public interface PropertyObjectSubject
{
  void addListener(PropertyChangeListener listener);
  void removeListener(PropertyChangeListener listener);
}
