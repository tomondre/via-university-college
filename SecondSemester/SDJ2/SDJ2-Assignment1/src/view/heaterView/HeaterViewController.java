package view.heaterView;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class HeaterViewController
{

  public Label radiatorLevelLabel;
  public Button turnUpButton;
  public Button turnDownButton;
  public Button backButton;

  private ViewHandler vh;
  private HeaterViewModel viewModel;

  public void init(ViewHandler vh, HeaterViewModel vm)
  {
    this.viewModel = vm;
    this.vh = vh;

    radiatorLevelLabel.textProperty().bind(viewModel.getHeaterLevelProperty());
  }

  public void onTurnUpPressed(ActionEvent actionEvent)
  {
    viewModel.turnHeaterUp();
  }

  public void onTurnDownPressed(ActionEvent actionEvent)
  {
    viewModel.turnHeaterDown();
  }

  public void onBackButton(ActionEvent actionEvent) throws IOException
  {
vh.openThermometerView();
  }
}
