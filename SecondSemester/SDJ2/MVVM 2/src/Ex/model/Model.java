package Ex.model;

import java.util.ArrayList;

public interface Model extends PropertyObjectSubject
{
  public ArrayList<Exercise> getAllExercises();
  public ArrayList<Exercise> getExercises(boolean completed);
  public Exercise getExercise(String number);
  public Exercise removeExercise(String number);
  public void addExercise(Exercise exercise);
  public Exercise editExercise(String number, Exercise exercise);
}
