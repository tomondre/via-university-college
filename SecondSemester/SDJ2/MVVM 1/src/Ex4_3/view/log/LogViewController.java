package Ex4_3.view.log;

import Ex4_3.core.LogViewModel;
import Ex4_3.view.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;

public class LogViewController
{
  @FXML private Button returnBackButton;
  @FXML private ListView<String> logField;

  private LogViewModel logVM;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, LogViewModel logVM)
  {
    this.logVM = logVM;
    this.viewHandler = viewHandler;
    logField.setItems(logVM.getLog());
    this.logVM.log();
  }

  public void returnBack(ActionEvent actionEvent) throws IOException
  {
    viewHandler.openView("");
  }
}
