package Ex.model;

public class Exercise
{
  private int sessionNumber;
  private int exerciseNumber;
  private String topic;
  private boolean completed;

  public Exercise(int sessionNumber, int exerciseNumber, String topic)
  {
    if (topic == null || topic.isEmpty())
    {
      throw new IllegalArgumentException("Empty topic");
    }
    this.topic = topic;
    setSessionNumber(sessionNumber);
    setExerciseNumber(exerciseNumber);
    this.completed = false;
  }

  public String getNumber()
  {
    return sessionNumber + "." + exerciseNumber;
  }

  public int getSessionNumber()
  {
    return sessionNumber;
  }

  public int getExerciseNumber()
  {
    return exerciseNumber;
  }

  public void setSessionNumber(int sessionNumber)
  {
    if (sessionNumber < 1)
    {
      throw new IllegalArgumentException("Illegal session number");
    }
    this.sessionNumber = sessionNumber;
  }

  public void setExerciseNumber(int exerciseNumber)
  {
    if (exerciseNumber < 1)
    {
      throw new IllegalArgumentException("Illegal exercise number");
    }
    this.exerciseNumber = exerciseNumber;
  }

  public String getTopic()
  {
    return topic;
  }

  public boolean isCompleted()
  {
    return completed;
  }

  public void setCompleted(boolean completed)
  {
    this.completed = completed;
  }

  public String toString(boolean status)
  {
    String s = getNumber() + " " + getTopic();
    if (status)
    {
      if (completed)
      {
        s += " (completed)";
      }
      else
      {
        s += " (not completed)";
      }
    }
    return s;
  }

  @Override public String toString()
  {
    return toString(true);
  }

  @Override public boolean equals(Object obj)
  {
    if (!(obj instanceof Exercise))
      return false;

    Exercise other = (Exercise) obj;
    return sessionNumber == other.sessionNumber
        && exerciseNumber == other.exerciseNumber && topic
        .equalsIgnoreCase(other.topic) && completed == other.completed;
  }
}
