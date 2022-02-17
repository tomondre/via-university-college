package Ex4_3.view.uppercase;

import Ex4_3.core.UppercaseViewModel;
import Ex4_3.core.LogViewModel;
import Ex4_3.view.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UppercaseViewController
{

  @FXML private Label errorLabel;
  @FXML private TextField replyField;
  @FXML private TextField requestField;

  private UppercaseViewModel viewModel;
private ViewHandler handler;

  @FXML public void onSubmitButton(ActionEvent actionEvent)
  {
    System.out.println("SubmitPressed");
    viewModel.convert();
  }

  @FXML public void onOpenLog(ActionEvent actionEvent)
  {
    viewModel.clear();
    try
    {
      handler.start("Log");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

    public void init(ViewHandler handler, UppercaseViewModel uppercaseVM)
  {
    this.handler = handler;
    this.viewModel = uppercaseVM;
    errorLabel.textProperty().bind(viewModel.errorProperty());
    requestField.textProperty().bindBidirectional(viewModel.requestProperty());
    replyField.textProperty().bind(viewModel.replyProperty());
  }

}
