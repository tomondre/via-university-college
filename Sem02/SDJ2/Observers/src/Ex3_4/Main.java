package Ex3_4;

import Ex3_4.observers.Counter;
import Ex3_4.observers.DreamTeamFan;
import Ex3_4.observers.OldBoysFan;
import Ex3_4.subject.SoccerMatch;

public class Main
{
  public static void main(String[] args)
  {
    SoccerMatch match = new SoccerMatch();
    Counter counter = new Counter();
    DreamTeamFan dreamTeamFan = new DreamTeamFan();
    OldBoysFan oldBoysFan = new OldBoysFan();

    match.addPropertyChangeListener(counter);
    match.addPropertyChangeListener(oldBoysFan);
    match.addPropertyChangeListener(dreamTeamFan);
    match.startMatch();

  }
}
