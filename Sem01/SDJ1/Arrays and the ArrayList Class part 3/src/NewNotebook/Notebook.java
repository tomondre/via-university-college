package NewNotebook;

import java.util.ArrayList;

public class Notebook
{
  private ArrayList<Note> notes;
  private int numberOfNotes;

  public Notebook(int MaxNumberOfNotes)
  {
    notes = new ArrayList<Note>(MaxNumberOfNotes);
  }

  public Notebook()
  {
    notes = new ArrayList<Note>(5);
  }

  public int getNumberOfNotes()
  {
    return notes.size();
  }

  public Note getNote(int index)
  {
    return notes.get(index);
  }

  public String getMessage(int index)
  {
    return notes.get(index).getMessage();
  }

  public void addNote(Note notee)
  {
    notes.add(notee);
  }

  public void addNote(String message)
  {

    notes.add(new Note(message));
  }

  public void addHighPriorityNote(String message)
  {
    Note temp = new Note(message);
    temp.setToHighPriority();
    notes.add(temp);
  }

  public void removeNote(int index)
  {
    notes.remove(index);
  }

  public Note[] getAllNotes()
  {
    Note[] temp = new Note[notes.size()];
    return notes.toArray(temp);
  }

  public int getNumberOfHighPriorityNotes()
  {
    int counter = 0;
    for (int i = 0; i < notes.size(); i++)
    {
      if (notes.get(i).isHighPriority())
      {
        counter++;
      }
    }
    return counter;
  }

  public void setToHighPriority(int ind)
  {
    notes.get(ind).setToHighPriority();
  }

  public Note[] getAllHighPriorityNotes()
  {
    ArrayList<Note> temp = new ArrayList<Note>(getNumberOfHighPriorityNotes());

    for (int i = 0; i < notes.size()  ; i++)
    {
      if (notes.get(i).isHighPriority())
      {
temp.add(notes.get(i));
      }
    }

    return temp.toArray(new Note[temp.size()]);
  }



  public static void main(String[] args)
  {
    Note n1 = new Note("Heya");
    Note n2 = new Note("oo");
    Note n3 = new Note("ofdfdfo");
    Notebook notebook = new Notebook();
    notebook.addNote(n1);
    notebook.addNote(n2);
    notebook.addNote(n3);
    System.out.println(notebook.getNumberOfNotes());
    System.out.println(notebook.getMessage(0));
    Note[] temp = notebook.getAllNotes();
    for (int i = 0; i < temp.length; i++)
    {
      System.out.println(temp[i]);
    }
    notebook.getNote(0).setToHighPriority();
    notebook.getNote(1).setToHighPriority();
    System.out.println(notebook.getNumberOfHighPriorityNotes());
    for (int i = 0; i < temp.length; i++)
    {
      System.out.println(temp[i]);
    }

    temp = notebook.getAllHighPriorityNotes();
    for (int i = 0; i < temp.length; i++)
    {
      System.out.println(temp[i]);
    }




  }
}
