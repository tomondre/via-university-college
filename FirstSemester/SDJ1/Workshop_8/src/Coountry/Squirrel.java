package Coountry;

public class Squirrel extends Animal
{
  private double maxSpeed;
  private int nuts;

  public Squirrel(double maxSpeed)
  {
    super(2);
    this.maxSpeed = maxSpeed;
  }

  public void saveNut()
  {
    nuts++;
  }

  public int getNumOfNuts()
  {
    return nuts;
  }

  public String getSound()
  {
  return "";
  }

  public String toString()
  {
    return super.toString() + ", MaxSpeed: " + maxSpeed + ", nunts: " + nuts;
  }
  public double getMaxSpeed()
  {
    return maxSpeed;
  }
  public String getType()
  {
    return "squirrel";
  }
}
