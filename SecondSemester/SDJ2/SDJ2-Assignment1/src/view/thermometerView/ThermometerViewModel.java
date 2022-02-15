package view.thermometerView;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ThermometerViewModel implements PropertyChangeListener
{
  private final StringProperty[] thermometerProperties;

  private final Model model;
  private final StringProperty errorProperty;
  private final StringProperty criticalValueProperty;

  public ThermometerViewModel(Model model)
  {
    this.model = model;
    model.addListener(this);
    errorProperty = new SimpleStringProperty();
    criticalValueProperty = new SimpleStringProperty();
    thermometerProperties = new SimpleStringProperty[3];

    //Initializing thermometers value fields
    for (int i = 0; i < thermometerProperties.length; i++)
    {
      thermometerProperties[i] = new SimpleStringProperty();
      thermometerProperties[i]
          .set(String.valueOf(model.getLastThermometerValue(i)));
    }
  }

  public StringProperty getThermometerProperty(int thermometerID)
  {
    return thermometerProperties[thermometerID];
  }

  public StringProperty criticalValuePropertyProperty()
  {
    return criticalValueProperty;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      int thermometerChangedID = (int) evt.getOldValue();

      //Checks if event is change temperature of the Thermometer and sets the specific StringProperty of Thermometer
      if (evt.getPropertyName().equals("ThermometerChange"))
      {
        for (int i = 0; i < thermometerProperties.length; i++)
        {
          if (thermometerChangedID == i)
          {
            String lastDoubleTemperatureAsString = String
                .valueOf(model.getLastThermometerValue(thermometerChangedID));
            thermometerProperties[i].set(lastDoubleTemperatureAsString);
          }
        }
      }

      //Checks if event it related to passing critical values
      if (model.outsideCriticalValues())
      {
        errorProperty.set("Temperature Outside Critical Values");
      }
      else
      {
        errorProperty.set("");
      }
    });
  }

  public StringProperty getErrorProperty()
  {
    return errorProperty;
  }

  //Checks if input is valid and adds
  public void setHighCriticalValue() throws Exception
  {
    double doubleToSet;
    try
    {
      doubleToSet = Double.parseDouble(criticalValuePropertyProperty().get());
    }

    catch (RuntimeException e)
    {
      throw new Exception("Invalid high critical value");
    }

    if (doubleToSet <= model.getLowCriticalValue())
    {
      throw new Exception(
          "High critical value cant be smaller than low value \n Low Value: "
              + model.getLowCriticalValue());
    }

    if (doubleToSet > 50 || doubleToSet < -30)
    {
      throw new Exception("Invalid low critical value");
    }

    model.setHighCriticalValue(doubleToSet);
  }

  public void setLowCriticalValue() throws Exception
  {
    double doubleToSet;
    try
    {
      doubleToSet = Double.parseDouble(criticalValuePropertyProperty().get());
    }
    catch (RuntimeException e)
    {
      throw new Exception("Invalid low critical value");
    }

    if (doubleToSet >= model.getHighCriticalValue())
    {
      throw new Exception(
          "Low critical value cant be bigger than high value \n High Value: "
              + model.getHighCriticalValue());
    }

    if (doubleToSet > 50 || doubleToSet < -30)
    {
      throw new Exception("Invalid low critical value");
    }

    model.setLowCriticalValue(doubleToSet);
  }
}
