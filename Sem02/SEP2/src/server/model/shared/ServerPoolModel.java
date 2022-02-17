package server.model.shared;

import shared.callback.UpdateType;
import shared.util.PropertyChangeSubject;

import java.beans.PropertyChangeListener;

public interface ServerPoolModel extends PropertyChangeSubject
{
  void update(UpdateType type);
}
