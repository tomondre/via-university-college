package view.historyView;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class HistoryViewModel implements PropertyChangeListener
{

  private final StringProperty heading;

  private int selectedThermID;
  private final Model model;
  private final ObservableList<String> selectedThermHistory;

  public HistoryViewModel(Model model)
  {
    heading = new SimpleStringProperty();
    this.model = model;
    model.addListener(this);

    selectedThermHistory = FXCollections.observableArrayList();
  }

  public ObservableList<String> getThermHistory()
  {
    selectedThermHistory
        .setAll(model.getThermometerHistory(selectedThermID).toString());
    return selectedThermHistory;
  }

  public StringProperty getHeading(){
    return heading;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if ((int) evt.getOldValue() == selectedThermID)
    {
      loadThermHistory();
    }
  }

  public void setIndex(int selectedThermID)
  {
    this.selectedThermID = selectedThermID;
    loadThermHistory();

    if (selectedThermID == 0)
    {
      heading
          .set("External thermometer number " + selectedThermID);
    }
    else {
      heading
          .set("Internal thermometer number " + selectedThermID);
    }
  }

  private void loadThermHistory()
  {
    selectedThermHistory.clear();
    ArrayList<Double> temp = model.getThermometerHistory(selectedThermID);

    for (Double d : temp)
    {
      selectedThermHistory.add(d.toString());
    }
  }

  public int getSelectedThermID(){
    return selectedThermID;
  }
}