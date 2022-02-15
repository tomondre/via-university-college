package Ex21_1;

import Ex21_1.behaviour.AggressiveBehaviour;
import Ex21_1.behaviour.DefensiveBehaviour;
import Ex21_1.behaviour.NeutralBehaviour;

public class RunRobot
{
  public static void main(String[] args)
  {
    Robot robot = new Robot("Test Robot", new GameBoard());
    robot.move();

    robot.setBehaviourStrategy(new DefensiveBehaviour());
    robot.move();

    robot.setBehaviourStrategy(new AggressiveBehaviour());
    robot.move();
  }
}
