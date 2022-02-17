package Ex6_3.view;

import Ex6_3.model.DoorModel;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DoorVM implements PropertyChangeListener
{
  private StringProperty doorStatus;
  private DoorModel model;

  public DoorVM(DoorModel model)
  {
    this.model = model;
    model.addPropertyChangeListener(this);
    doorStatus = new SimpleStringProperty();
  }

  public StringProperty statusProperty()
  {
    return doorStatus;
  }

  public void pressDoorButton()
  {
    model.pressDoorButton();

      doorStatus.set(model.getState());

  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      doorStatus.set(model.getState());
    });
  }
}
