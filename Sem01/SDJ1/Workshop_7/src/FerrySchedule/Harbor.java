package FerrySchedule;

public class Harbor
{
  private String name, town;

  public Harbor(String name, String town)
  {
    this.name = name;
    this.town = town;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getTown()
  {
    return town;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Harbor))
    {
      return false;
    }
    Harbor other = (Harbor) obj;

    return name.equals(other.name) && town.equals(other.town);
  }
}
