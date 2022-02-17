package Animal;

import java.util.Objects;

public class Frog extends Animal
{
  private String colour;

  public Frog(int age, String colour)
  {
    super(age);
    this.colour = colour;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    if (!super.equals(o))
      return false;
    Frog frog = (Frog) o;
    return Objects.equals(colour, frog.colour);
  }

  @Override public int hashCode()
  {
    return Objects.hash(super.hashCode(), colour);
  }

  @Override public String toString()
  {
    return "Frog{" + "colour='" + colour + '\'' + '}';
  }

  public String speak()
  {
    return "kvak";
  }
}
