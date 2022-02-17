package Ex3_4.subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class SoccerMatch implements Ex3_4.subject.PropertyChangeSubject
{
  PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

  public String team0 = "Dream Team";
  public String team1 = "Old Boys";

  public void startMatch()
  {
    System.out.println("Match starting \n\n");
    Random random = new Random();
    for (int i = 0; i < 90; i++)
    {

      int rand = random.nextInt(100);
      int whichTeam = random.nextInt(2);

      if (rand < 8)
      {
        // score goal
        scoreGoal(whichTeam);
      }
      else if (rand < 12)
      {
        // penalty
        roughTackle(whichTeam);
      }

      try
      {
        Thread.sleep(100);
      }
      catch (InterruptedException e)
      {
        break;
      }
    }

    System.out.println("\n\nMatch ended");
    propertyChangeSupport.firePropertyChange("End",-1,0);
  }

  private void roughTackle(int whichTeam)
  {
    if (whichTeam == 0)
    {
      System.out.println("\nDreamTeamRoughTackle");
      propertyChangeSupport.firePropertyChange("RoughTackle", 0, team0);
    }
    else
    {
      System.out.println("\nOldBoysRoughTackle");
      propertyChangeSupport.firePropertyChange("RoughTackle", 0, team1);
    }
  }

  private void scoreGoal(int whichTeam)
  {
    if (whichTeam == 0)
    {
      System.out.println("\nDreamTeamScores");
      propertyChangeSupport.firePropertyChange("Scores", 0, team0);
    }
    else
    {
      System.out.println("\nOldBoysScores");
      propertyChangeSupport.firePropertyChange("Scores", 0, team1);
    }
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }
}