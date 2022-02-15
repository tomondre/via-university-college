package TVSeries;

import java.util.ArrayList;

public class TVSeries
{
  private String title;
  private int numberOfEpisodes;
  private ArrayList<Actor> actors;

  public TVSeries(String title)
  {
    this.title = title;
  }

  public void hireActor(Actor actor)
  {
    actors.add(actor);
  }

  public int getNumberOfActors()
  {
    return actors.size();
  }

  public Actor getActor(int index)
  {
    return actors.get(index);
  }

  public void awardEmmy(String name)
  {
    for (int i = 0; i < actors.size(); i++)
    {
      if (actors.get(i).getName().equals(name))
      {
        actors.get(i).awardEmmy();
      }
    }
  }

  public void makeNewEpisode()
  {
    numberOfEpisodes++;
  }

  public ArrayList<Actor> getEmmyWinners()
  {
    ArrayList<Actor> temp = new ArrayList<Actor>();
    for (int i = 0; i < actors.size(); i++)
    {
      if (actors.get(i).getNumberOfEmmys() > 0)
      {
        temp.add(actors.get(i));
      }
    }
    return temp;

  }
}
