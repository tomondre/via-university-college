package Ex22_3.Ex22_3_2;

public class Project
{
  private String name;
  private ProjectGlossary glossary;

  public Project(String name)
  {
    this.name = name;
    glossary = ProjectGlossary.getInstance();
  }

  public String getName()
  {
    return name;
  }

  public ProjectGlossary getGlossary()
  {
    return glossary;
  }

  public String getDefinition(String phrase)
  {
    return glossary.getDefinition(phrase);
  }

  public void addGlossaryItem(String phrase, String definition)
  {
    glossary.addItem(phrase, definition);
  }

  public void removeGlossaryItem(String phrase)
  {
    this.glossary.removeItem(phrase);
  }

  public String toString()
  {
    return "Project name: " + name + glossary;
  }
}
