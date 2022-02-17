package Ex.view;

import Ex.model.Exercise;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SimpleExerciseViewModel
{
  private StringProperty numberProperty;
  private StringProperty topicProperty;
  private ObjectProperty<Boolean> completedProperty;

  public SimpleExerciseViewModel(Exercise exercise)
  {
    this.numberProperty = new SimpleStringProperty();
    this.topicProperty = new SimpleStringProperty();
    this.completedProperty = new SimpleObjectProperty();

    numberProperty.set(exercise.getNumber());
    topicProperty.set(exercise.getTopic());
    completedProperty.set(exercise.isCompleted());
  }

  public StringProperty numberPropertyProperty()
  {
    return numberProperty;
  }

  public StringProperty topicPropertyProperty()
  {
    return topicProperty;
  }

  public ObjectProperty getCompletedProperty()
  {
    return completedProperty;
  }
}
