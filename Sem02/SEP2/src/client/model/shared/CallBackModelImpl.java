package client.model.shared;

import shared.util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Subject class containing methods for the observer pattern
 */
public class CallBackModelImpl implements CallBackModel, PropertyChangeListener
{
  private PropertyChangeSupport support;
  private PropertyChangeSubject subject;

  /**
   * Constructor where the corresponding client is passed as an argument, the support is initialized and the class is added as a listener to the client
   * @param client argument, which will be assigned to the local private field
   */
  public CallBackModelImpl(Object client)
  {
    support = new PropertyChangeSupport(this);
    subject = (PropertyChangeSubject) client;
    subject.addPropertyChangeListener(null, this);
  }

  /**
   * The method called when event is fired from the subject class
   * @param evt object containing the type of the event
   */
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
    System.out.println(evt.getPropertyName());
  }

  /**
   * Registers a listener to this class
   * @param name the name of the event the listener is listening to
   * @param listener the listener object
   */
  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if (name == null)
    {
      support.addPropertyChangeListener(listener);
    }
    else
    {
      support.addPropertyChangeListener(name, listener);
    }
  }

  /**
   * Removes the listener from the list of listeners
   * @param name the event for which the listener wants to unsubscribe
   * @param listener the listener object
   */
  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }
}
