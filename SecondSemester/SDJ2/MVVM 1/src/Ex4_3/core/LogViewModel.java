package Ex4_3.core;

import Ex4_3.model.TextConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class LogViewModel
{
  private TextConverter model;
  private ObservableList<String> logs;

  public LogViewModel(TextConverter converter)
  {
    model = converter;
    logs = FXCollections.observableArrayList();
  }

  public void log()
  {
    logs.setAll(model.getLog());
  }

  public ObservableList<String> getLog(){
    return logs;
  }

}
