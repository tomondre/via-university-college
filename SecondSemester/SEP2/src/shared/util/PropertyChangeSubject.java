package shared.util;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject
{
    void addPropertyChangeListener(String name, PropertyChangeListener listener);
    void removePropertyChangeListener(String name, PropertyChangeListener listener);
}
