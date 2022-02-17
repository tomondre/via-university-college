package Ex.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelManager implements Model
{
  private ExerciseList list;
  private PropertyChangeSupport property;

  public ModelManager()
  {
    property = new PropertyChangeSupport(this);
    list = new ExerciseList();
    createDummyData();
  }

  private void createDummyData()
  {
    list.addExercise(new Exercise(3, 1, "Observer"));
    list.addExercise(new Exercise(1, 2, "Threads"));
    list.addExercise(new Exercise(1, 1, "Threads"));
    list.addExercise(new Exercise(2, 2, "State"));
    list.getExercise("1.1").setCompleted(true);
    System.out.println(list);
  }

  @Override public ArrayList<Exercise> getAllExercises()
  {
    return list.getAllExercises();
  }

  @Override public ArrayList<Exercise> getExercises(boolean completed)
  {
    return list.getExercises(completed);
  }

  @Override public Exercise getExercise(String number)
  {
    return list.getExercise(number);
  }

  @Override public Exercise removeExercise(String number)
  {
    Exercise exercise = list.removeExercise(number);
    System.out.println("REMOVING: " + exercise);
    property.firePropertyChange("Remove", number, exercise);
    return exercise;
  }

  @Override public Exercise editExercise(String number, Exercise exercise)
  {
    if (!number.equals(exercise.getNumber()))
    {
      Exercise sameNumber = list.getExercise(exercise.getNumber());
      if (sameNumber != null)
      {
        throw new IllegalStateException("Number already exist " + exercise.getNumber());
      }
    }
    Exercise removedExercise = list.removeExercise(number);
    if (removedExercise == null)
    {
      throw new IllegalStateException("Cannot find number " + number);
    }
    list.addExercise(exercise);
    System.out.println("EDITING: " + removedExercise + " - to: " + exercise);
    property.firePropertyChange("Edit", number, exercise);
    return exercise;
  }

  @Override public void addExercise(Exercise exercise)
  {
    list.addExercise(exercise);
    System.out.println("ADDING: " + exercise);
    property.firePropertyChange("Add", exercise.getNumber(), exercise);
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    property.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    property.removePropertyChangeListener(listener);
  }
}
