import java.util.Random;
public class Game
{
  Random rand = new Random();
  private int points;
  public Game(int points)
  {
    this.points = points;
  }
  public int getPoints()
  {
    return points;
  }
  public void setPoints(int points)
  {
    this.points = points;
  }
  public void rollDice()
  {
    System.out.println("Rolling the dice ");

  }

}
