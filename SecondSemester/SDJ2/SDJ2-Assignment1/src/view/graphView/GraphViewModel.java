package view.graphView;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GraphViewModel implements PropertyChangeListener
{
  private final Model model;
  private int selectedItemID;
  private final ObservableList<XYChart.Series<String, Number>> allThermHistory;

  public GraphViewModel(Model model)
  {
    this.model = model;
    model.addListener(this);
    allThermHistory = FXCollections.observableArrayList();

    for (int i = 0; i < 3; i++)
    {
      XYChart.Series temp = new XYChart.Series<String, Number>();
      temp.setName("Indoor Thermometer no: " + i);
      allThermHistory.add(temp);
    }
    allThermHistory.get(0).setName("Outdoor thermometer no: " + 0);
  }

  public ObservableList<XYChart.Series<String, Number>> getThermHistory()
  {
    return allThermHistory;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      if (evt.getPropertyName().equals("ThermometerChange"))
      {
        ObservableList<XYChart.Data<String, Number>> tempSeries = getThermHistory()
            .get((int) evt.getOldValue()).getData();

        tempSeries.add(
            new XYChart.Data<String, Number>(String.valueOf(tempSeries.size()),
                (double) evt.getNewValue()));

      }
    });

    //    Platform.runLater(() -> {
    //      if ((int) evt.getOldValue() == selectedThermID)
    //      {
    //        loadThermHistory();
    //      }
    //    });
  }

  public void setSelectedItemID(int selectedThermID)
  {
    selectedItemID = selectedThermID;
  }

  public int getSelectedItemID()
  {
    return selectedItemID;
  }
}

