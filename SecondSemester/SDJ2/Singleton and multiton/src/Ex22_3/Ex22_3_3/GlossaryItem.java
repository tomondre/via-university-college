package Ex22_3.Ex22_3_3;

public class GlossaryItem
{
  private String definition;
  private String phrase;

  public GlossaryItem(String phrase, String definition)
  {
    this.phrase = phrase;
    this.definition = definition;
  }

  public String getPhrase()
  {
    return phrase;
  }

  public String getDefinition()
  {
    return definition;
  }

  public void setDefinition(String definition)
  {
    this.definition = definition;
  }

  public String toString()
  {
    return "- " + phrase + ": \"" + definition + "\"";
  }
}
