package TVSeries;

public class Actor
{
  private String name;
  private int numberOfEmmys, numberOfEpisodes;

  public Actor(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public int getNumberOfEmmys()
  {
    return numberOfEmmys;
  }

  public int getNumberOfEpisodes()
  {
    return numberOfEpisodes;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void awardEmmy()
  {
    numberOfEmmys++;
  }

  public void participateInEpisode()
  {
    numberOfEpisodes++;
  }

}

