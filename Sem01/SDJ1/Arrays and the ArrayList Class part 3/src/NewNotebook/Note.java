package NewNotebook;

public class Note
{
  private String message;
  private boolean highPriority;

  public Note(String message)
  {
    this.message = message;
  }

  public String getMessage()
  {
    return message;
  }

  public void setMessage(String message)
  {
    this.message = message;
  }

  public boolean isHighPriority()
  {
    return highPriority;
  }

  public void setToHighPriority()
  {
    highPriority = true;
  }

  public void setToLowPriority()
  {
    highPriority = false;
  }

  public Note copy()
  {
    Note temp = new Note(message);
    if (isHighPriority())
    {
      temp.setToHighPriority();
    }
    return temp;
  }

  public String toString()
  {
    return "Message: " + message + " priority: " + (highPriority ?
        "high" :
        "low");
  }

  public static void main(String[] args)
  {
    Note note = new Note("Heya");

    System.out.println(note);
    System.out.println(note.isHighPriority());
  }
}
