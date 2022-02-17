package Ex21_1;

import Ex21_1.behaviour.Behaviour;
import Ex21_1.behaviour.NeutralBehaviour;

public class Robot
{
  private String name;
  private Behaviour behaviourStrategy;
  private GameBoard board;

  public Robot(String name, GameBoard board)
  {
    this.name = name;
    this.board = board;
    behaviourStrategy = new NeutralBehaviour();
  }

  public Behaviour getBehaviour()
  {
    return behaviourStrategy;
  }

  public void setBehaviourStrategy(Behaviour behaviourStrategy)
  {
    this.behaviourStrategy = behaviourStrategy;
  }

  public void move()
  {
    behaviourStrategy.moveCommand(board, new Point2D(2, 3));
  }
}
