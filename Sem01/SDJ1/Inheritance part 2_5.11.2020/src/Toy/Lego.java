package Toy;

public class Lego extends Toy
{
  private int numberOfBricks;

  public Lego(int suitableAge, int numberOfBricks)
  {
    super(suitableAge);
    this.numberOfBricks = numberOfBricks;
  }

  public String play()
  {
    return "Build";
  }

}
