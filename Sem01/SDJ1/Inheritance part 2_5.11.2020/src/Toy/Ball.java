package Toy;

public abstract  class Ball extends Toy
{
  private int diameter;

  public Ball(int suitableAge, int diameter)
  {
    super(suitableAge);
    this.diameter = diameter;
  }
}
