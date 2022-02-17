package Ex21_1.behaviour;

import Ex21_1.GameBoard;
import Ex21_1.Point2D;

public interface Behaviour
{
  int moveCommand(GameBoard board, Point2D robotLocation);
}
