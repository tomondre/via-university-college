package Animal;

import java.util.Objects;

public class Bee extends Animal
{
  private boolean isHoneyBee;

  public Bee(int age, boolean isHoneyBee)
  {
    super(age);
    this.isHoneyBee = isHoneyBee;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    if (!super.equals(o))
      return false;
    Bee bee = (Bee) o;
    return isHoneyBee == bee.isHoneyBee;
  }

  @Override public int hashCode()
  {
    return Objects.hash(super.hashCode(), isHoneyBee);
  }

  @Override public String toString()
  {
    return "Bee{" + "isHoneyBee=" + isHoneyBee + '}';
  }

  public String speak()
  {
    return "bzz";
  }
}
