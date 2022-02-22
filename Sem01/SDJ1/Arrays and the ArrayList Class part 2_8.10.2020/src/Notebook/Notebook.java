package Notebook;

import java.util.Arrays;

public class Notebook
{
  private Note[] note;
  private int numberOfNotes;

  public Notebook(int MaxNumberOfNotes)
  {
    note = new Note[MaxNumberOfNotes];
  }

  public int getNumberOfNotes()
  {
    return note.length;
  }

  public Note getNote(int index)
  {
    return note[index].copy();
  }

  public String getMessage(int index)
  {
    return note[index].getMessage();
  }

  public void addNote(Note notee)
  {
    for (int i = 0; i < note.length; i++)
    {
      if (note[i] == null)
      {
        note[i] = notee.copy();
        break;
      }
    }
  }

  public void addNote(String message)
  {
    for (int i = 0; i < note.length; i++)
    {
      if (note[i] == null)
      {
        note[i] = new Note(message);
        break;
      }
    }
  }

  public void addHighPriorityNote(String message)
  {
    for (int i = 0; i < note.length; i++)
    {
      if (note[i] == null)
      {
        note[i] = new Note(message);
        note[i].setToHighPriority();
        break;
      }
    }
  }

  public void removeNote(int index)
  {
    note[index] = null;
  }

  public Note[] getAllNotes()
  {
    return note;
  }

  public int getNumberOfHighPriorityNotes()
  {
    int number = 0;
    for (int i = 0; i < note.length; i++)
    {
      if (note[i].isHighPriority())
      {
        number++;
      }
    }
    return number;
  }

  @Override public String toString()
  {
    return "note=" + Arrays.toString(note) + ", numberOfNotes=" + numberOfNotes
        + '}';
  }

  public void setToHighPriority(int ind)
  {
    note[ind].setToHighPriority();
  }

  public Note[] getAllHighPriorityNotes()
  {
    Note[] temp;
    temp = new Note[getNumberOfHighPriorityNotes()];
    for (int i = 0; i < note.length; i++)
    {
      if (note[i].isHighPriority())
      {
        for (int x = 0; x < temp.length; x++)
        {
          if (temp[x] == null)
          {
            temp[x] = note[i].copy();
            break;
          }
        }
      }
    }
    return temp;
  }

  public static void main(String[] args)
  {
    Note n1 = new Note("Heya");
    Note n2 = new Note("oo");
    Notebook notebook = new Notebook(3);
    System.out.println(notebook);
    notebook.addNote(n1);

    System.out.println(notebook);

    notebook.addNote(n2);

    notebook.setToHighPriority(1);

    System.out.println(notebook);

    notebook.addHighPriorityNote("lll");

    System.out.println(notebook);

    System.out.println(notebook.getNumberOfHighPriorityNotes());

    Note[] temp = notebook.getAllHighPriorityNotes();
    for (int i = 0; i < temp.length; i++)
    {
      System.out.println(temp[i]);
    }
  }
}
