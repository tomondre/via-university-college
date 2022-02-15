package Coountry;

public class Spider extends Animal
{
  private int eyes;

  public Spider(int eyes, int legs)
  {
    super(legs);
    this.eyes = eyes;
  }

  public int getEyes()
  {
    return eyes;
  }

  public String getSound()
  {
    return " ";
  }

  public String toString()
  {
    return super.toString() + ", Eyes: " + eyes;
  }

}
