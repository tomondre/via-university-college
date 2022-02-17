package client.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.graphView.GraphViewController;
import view.heaterView.HeaterViewController;
import view.historyView.HistoryViewController;
import view.thermometerView.ThermometerViewController;

import java.io.IOException;

public class ViewHandler
{
  private final ViewModelFactory vmf;
  private Scene thermometerScene;
  private Scene heaterScene;
  private Scene historyScene;
  private Scene graphScene;

  private final Stage stage;
  private FXMLLoader loader;
  private Parent root;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
    stage = new Stage();
    loader = new FXMLLoader();
    root = null;
  }

  public void start() throws IOException
  {
    openThermometerView();
  }

  public void openThermometerView() throws IOException
  {
    openView("Thermometer", -1);
  }

  public void openHeaterView() throws IOException
  {
    openView("Heater", -1);
  }

  public void openHistoryView(int indexOfThermToOpen) throws IOException
  {
    openView("History", indexOfThermToOpen);
  }

  public void openGraphView(int selectedThermID) throws IOException
  {
    openView("Graph", selectedThermID);
  }

  private void openView(String viewToOpen, int selectedThermID)
      throws IOException
  {
    switch (viewToOpen)
    {
      case "Thermometer":
        if (thermometerScene == null)
        {
          loadLocation(viewToOpen);

          ThermometerViewController view = loader.getController();
          view.init(this, vmf.getThermometerVM());

          stage.setTitle("Thermometers");
          thermometerScene = new Scene(root);
        }
        stage.setScene(thermometerScene);
        break;

      case "Heater":
        if (heaterScene == null)
        {
          loadLocation(viewToOpen);
          HeaterViewController view = loader.getController();
          view.init(this, vmf.getHeaterVM());
          stage.setTitle("Heater");

          heaterScene = new Scene(root);
        }

        stage.setScene(heaterScene);
        break;

      case "History":
        if (historyScene == null)
        {
          loadLocation(viewToOpen);
          HistoryViewController view = loader.getController();
          view.init(this, vmf.getHistoryVM());
          stage.setTitle("History");

          historyScene = new Scene(root);
        }

        vmf.getHistoryVM().setIndex(selectedThermID);
        stage.setScene(historyScene);
        break;

      case "Graph":
        if (graphScene == null)
        {
          loadLocation(viewToOpen);
          GraphViewController view = loader.getController();
          view.init(this, vmf.getGraphViewModel());
          stage.setTitle("Graph");

          graphScene = new Scene(root);
        }
        vmf.getGraphViewModel().setSelectedItemID(selectedThermID);
        stage.setScene(graphScene);
        break;
    }
    stage.setResizable(false);
    stage.show();
  }

  public void loadLocation(String viewToOpen) throws IOException
  {
    loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(
        "../view/" + viewToOpen.toLowerCase() + "View/" + viewToOpen
            + "View.fxml"));
    root = loader.load();
  }
}
