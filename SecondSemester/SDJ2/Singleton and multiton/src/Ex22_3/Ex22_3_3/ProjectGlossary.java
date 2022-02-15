package Ex22_3.Ex22_3_3;

import java.util.ArrayList;
import java.util.HashMap;

public class ProjectGlossary
{
  private ArrayList<GlossaryItem> items;
  private static HashMap<MultitonKey, ProjectGlossary> instances = new HashMap<>();

  private ProjectGlossary()
  {
    items = new ArrayList<GlossaryItem>();
  }

  public static ProjectGlossary getInstance(MultitonKey key)
  {
    ProjectGlossary instance = instances.get(key);
    if (instance == null)
    {
      instance = new ProjectGlossary();
      instances.put(key, instance);
    }
    return instance;
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
}
