package Animal;

import java.util.Objects;

public class Cat extends Pet
{
  private boolean isAHouseCat;

  public Cat(int age, String name, boolean isAHouseCat)
  {
    super(age, name);
    this.isAHouseCat = isAHouseCat;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    if (!super.equals(o))
      return false;
    Cat cat = (Cat) o;
    return isAHouseCat == cat.isAHouseCat;
  }

  @Override public int hashCode()
  {
    return Objects.hash(super.hashCode(), isAHouseCat);
  }

  @Override public String toString()
  {
    return "Cat{" + "isAHouseCat=" + isAHouseCat + '}';
  }

  public String speak()
  {
    return "Mnau";

  }
}
