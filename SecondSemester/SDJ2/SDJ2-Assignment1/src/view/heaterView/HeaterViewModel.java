package view.heaterView;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HeaterViewModel implements PropertyChangeListener
{
  private final Model model;
  private final StringProperty heaterLevelProperty;

  public HeaterViewModel(Model model)
  {
    this.model = model;
    model.addListener(this);

    heaterLevelProperty = new SimpleStringProperty();
    heaterLevelProperty.set(String.valueOf(model.getHeaterLevel()));
  }

  public void turnHeaterUp()
  {
    model.turnHeaterUp();
  }

  public void turnHeaterDown()
  {
    model.turnHeaterDown();
  }

  public StringProperty getHeaterLevelProperty()
  {
    return heaterLevelProperty;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      if (evt.getPropertyName().equals("HeaterChange"))
      {
        heaterLevelProperty.set(String.valueOf(model.getHeaterLevel()));
      }
    });

  }
}
