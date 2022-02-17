package Ex22_3.Ex22_3_2;

import java.util.ArrayList;

public class ProjectGlossary
{
  private ArrayList<GlossaryItem> items;
  private static ProjectGlossary instance = new ProjectGlossary();

  private ProjectGlossary()
  {
    items = new ArrayList<GlossaryItem>();
  }

  public int size()
  {
    return items.size();
  }

  public GlossaryItem[] getAll()
  {
    return items.toArray(new GlossaryItem[0]);
  }

  public String getDefinition(String phrase)
  {
    for (GlossaryItem item : items)
    {
      if (item.getPhrase().equals(phrase))
      {
        return item.getDefinition();
      }
    }
    return null;
  }

  public void addItem(String phrase, String definition)
  {
    items.add(new GlossaryItem(phrase, definition));
  }

  public void removeItem(String phrase)
  {
    items.removeIf(item -> item.getPhrase().equals(phrase));
  }

  public String toString()
  {
    String temp = "";

    for (GlossaryItem item : items)
    {
      temp += "\n" + item;
    }
    return temp;
  }

  public static ProjectGlossary getInstance()
  {
    return instance;
  }
}
