package Ex3_3.subject;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject
{
  void addPropertyChangeListener(PropertyChangeListener listener);
  void removePropertyChangeListener(PropertyChangeListener listener);
}
