package view.graphView;

import client.core.ViewHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class GraphViewController
{
  public Button BackButton;
  public LineChart<String, Number> chart;
  public CategoryAxis xAxis;
  public NumberAxis yAxis;
  public Label header;

  private GraphViewModel viewModel;
  private ViewHandler handler;

  public void init(ViewHandler handler, GraphViewModel viewModel)
  {
    this.handler = handler;
    this.viewModel = viewModel;

    ObservableList<XYChart.Series<String, Number>> list = viewModel.getThermHistory();
    list.get(0).setName("Outdoor thermometer");
    list.get(1).setName("Indoor thermometer 1");
    list.get(2).setName("Indoor thermometer 2");

    chart.setData(list);
  }

  public void onBackButton(ActionEvent actionEvent) throws IOException
  {
    handler.openHistoryView(viewModel.getSelectedItemID());
  }
}
