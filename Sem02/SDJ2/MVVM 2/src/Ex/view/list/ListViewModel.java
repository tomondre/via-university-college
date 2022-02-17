package Ex.view.list;

import Ex.model.Exercise;
import Ex.model.Model;
import Ex.view.SimpleExerciseViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ListViewModel implements PropertyChangeListener
{
  private ObservableList<SimpleExerciseViewModel> exercises;
  private Model model;

  public ListViewModel(Model model)
  {
    exercises = FXCollections.observableArrayList();
    this.model = model;
    model.addListener(this);
    exercises.setAll();
  }

  public ObservableList<SimpleExerciseViewModel> getExerciseList(){
    return exercises;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    exercises.setAll(model.getAllExercises());
  }
}
