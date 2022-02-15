package Ex4_2.view;

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

  @FXML public void onSubmitButton(ActionEvent actionEvent)
  {
    System.out.println("SubmitPressed");
    viewModel.convert();
  }

  public void init(UppercaseViewModel uppercaseVM)
  {
    this.viewModel = uppercaseVM;
    errorLabel.textProperty().bind(viewModel.errorProperty());
    requestField.textProperty().bindBidirectional(viewModel.requestProperty());
    replyField.textProperty().bind(viewModel.replyProperty());
  }

  public void onOpenLog(ActionEvent actionEvent)
  {
  }
}
