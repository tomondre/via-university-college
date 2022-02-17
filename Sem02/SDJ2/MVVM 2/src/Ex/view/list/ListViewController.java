package Ex.view.list;

import Ex.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListViewController
{

  public TableView table;
  public TableColumn numberColumn;
  public TableColumn topicColumn;
  public TableColumn<> completedColumn;
  public Button removeButton;
  public Button manageButton;

  private ListViewModel vm;
private ViewHandler handler;

  public void init(ViewHandler handler, ListViewModel vm)
  {
    this.handler = handler;
    this.vm = vm;

    numberColumn.setCellValueFactory(new PropertyValueFactory<>("sessionNumber"));
    topicColumn.setCellValueFactory(new PropertyValueFactory<>("topic"));
    completedColumn
        .setCellValueFactory(new PropertyValueFactory<>("completed"));
    table.setItems(vm.getExerciseList());
  }

  public void onRemoveButton(ActionEvent actionEvent)
  {
handler.openManageView("Remove",);
  }

  public void onManageButton(ActionEvent actionEvent)
  {
//handler.openManageView("Edit");
  }
}
