package Ex21_1.behaviour;

import Ex21_1.GameBoard;
import Ex21_1.Point2D;

public class AggressiveBehaviour implements Behaviour
{

  @Override public int moveCommand(GameBoard board, Point2D robotLocation)
  {
    System.out.println("Moving aggressively");
    return 1;
  }


}
