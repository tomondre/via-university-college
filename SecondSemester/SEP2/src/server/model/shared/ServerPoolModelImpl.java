package server.model.shared;

import shared.callback.UpdateType;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ServerPoolModelImpl implements ServerPoolModel
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private static ServerPoolModelImpl instance = new ServerPoolModelImpl();

  private ServerPoolModelImpl()
  {
  }

  @Override public void update(UpdateType type)
  {
    support.firePropertyChange(type.toString(), -1, 0);
  }

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

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }

  public static ServerPoolModelImpl getInstance()
  {
    return instance;
  }
}
