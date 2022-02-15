package Ex6_3.view;

import Ex6_3.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DoorViewController
{
  public Button doorButton;
  public Label statusLabel;
  private DoorVM vm;

  public void init(DoorVM vm)
  {

    this.vm = vm;
    statusLabel.textProperty().bind(vm.statusProperty());
  }

  public void onDoorButton(ActionEvent actionEvent)
  {
    vm.pressDoorButton();
  }
}
