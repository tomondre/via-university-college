package view.thermometerView;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.IOException;

public class ThermometerViewController
{
  public Label t0Label;
  public Label t1Label;
  public Label t2Label;

  public Button openHeaterButton;

  public Button historyButton0;
  public Button onHistoryButton1;
  public Button onHistoryButton2;

  public Label errorLabel;

  public Button setHighButton;
  public Button setLowButton;
  public TextField criticalValueField;

  private ThermometerViewModel viewModel;
  private ViewHandler handler;

  public void init(ViewHandler handler, ThermometerViewModel model)
  {
    viewModel = model;
    this.handler = handler;
    t0Label.textProperty().bind(viewModel.getThermometerProperty(0));
    t1Label.textProperty().bind(viewModel.getThermometerProperty(1));
    t2Label.textProperty().bind(viewModel.getThermometerProperty(2));
    errorLabel.textProperty().bind(viewModel.getErrorProperty());
    criticalValueField.textProperty()
        .bindBidirectional(viewModel.criticalValuePropertyProperty());
  }

  public void onOpenHeaterButton(ActionEvent actionEvent) throws IOException
  {
    handler.openHeaterView();
  }

  public void onHistoryButton0(ActionEvent actionEvent) throws IOException
  {
    handler.openHistoryView(0);
  }

  public void onHistoryButton1(ActionEvent actionEvent) throws IOException
  {
    handler.openHistoryView(1);
  }

  public void onHistoryButton2(ActionEvent actionEvent) throws IOException
  {
    handler.openHistoryView(2);
  }

  public void onSetHigh(ActionEvent actionEvent)
  {
    try
    {
      viewModel.setHighCriticalValue();
    }
    catch (Exception e)
    {
      alertWindow(e.getMessage(), "Error");
    }
    criticalValueField.setText("");
  }

  public void onSetLow(ActionEvent actionEvent)
  {
    try
    {
      viewModel.setLowCriticalValue();
    }
    catch (Exception e)
    {
      alertWindow(e.getMessage(), "Error");
    }
    criticalValueField.setText("");
  }

  private void alertWindow(String alertMessage, String title)
  {
    JOptionPane.showMessageDialog(null, alertMessage, title,
        JOptionPane.INFORMATION_MESSAGE);
  }

}
