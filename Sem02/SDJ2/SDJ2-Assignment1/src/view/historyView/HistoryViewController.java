package view.historyView;

import client.core.ViewHandler;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class HistoryViewController
{
  public TableColumn<String, String> indexesColumn;
  public Button backButton;
  public TableView<String> historyTable;
  public TableColumn<String, String> tempColumn;
  public Label thermHistoryLabel;
  public Button graphButton;

  private ViewHandler handler;
  private HistoryViewModel viewModel;

  public void init(ViewHandler handler, HistoryViewModel viewModel)
  {
    this.handler = handler;
    this.viewModel = viewModel;
    thermHistoryLabel.textProperty().bind(viewModel.getHeading());

    tempColumn.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue()));
    indexesColumn.setCellValueFactory(data -> new SimpleStringProperty(
        String.valueOf(historyTable.getItems().indexOf(data.getValue()) + 1)));
    historyTable.setItems(viewModel.getThermHistory());

  }

  public void onBackButton(ActionEvent actionEvent) throws IOException
  {
    handler.openThermometerView();
  }

  public void onGraphButton(ActionEvent actionEvent) throws IOException
  {
    handler.openGraphView(viewModel.getSelectedThermID());
  }
}
