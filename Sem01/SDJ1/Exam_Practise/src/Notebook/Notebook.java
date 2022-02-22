package Notebook;

import java.util.ArrayList;

public class Notebook
{

  private ArrayList<Note> notes;
  private int numberOfNotes;

  public Notebook(int numberOfNotes)
  {
    notes = new ArrayList<Note>();
    this.numberOfNotes = numberOfNotes;
  }

  public void addNote(Note note)
  {
    notes.add(note.copy());
  }

  public void setNote(Note note, int index)
  {
    notes.set(index, note.copy());
  }

  public void remove(int index)
  {
    notes.remove(index);
  }

  public Note getNote(int index)
  {
    return notes.get(index).copy();
  }

  public int getNumberOfHighPriorityNumber()
  {
    int count = 0;
    for (Note note : notes)
    {
      if (note instanceof PriorityNote)
      {
        count++;
      }
    }
    return count;
  }

  public PriorityNote[] getPriorityNotes()
  {
    ArrayList<Note> temp = new ArrayList<Note>(getNumberOfHighPriorityNumber());

    for (int j = 1; j <= 3; j++)
    {

      for (int i = 0; i < notes.size(); i++)
      {

        if (notes.get(i) instanceof PriorityNote
            && ((PriorityNote) notes.get(i)).getPriority() == j)
        {
          temp.add(notes.get(i).copy());
        }
      }
    }

    return temp.toArray(new PriorityNote[temp.size()]);

  }

  public String toString()
  {
    return " Number of notes: " + numberOfNotes;
  }
}
