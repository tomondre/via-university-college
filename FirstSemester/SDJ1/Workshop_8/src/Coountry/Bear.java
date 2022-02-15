package Coountry;

public class Bear extends Animal
{
  private boolean sleeping;

  public Bear(boolean isSleeping, int legs)
  {
    super(legs);
    sleeping = isSleeping;
  }

  public boolean isASleep()
  {
    return sleeping;
  }

  public String getSound()
  {
    return "Brum";
  }

  public String toString()
  {
    return super.toString() + ", sleeping: " + sleeping;
  }
}
