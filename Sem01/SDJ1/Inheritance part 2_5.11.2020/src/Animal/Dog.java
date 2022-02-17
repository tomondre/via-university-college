package Animal;

import java.util.Objects;

public class Dog extends Pet
{
  private String breed;

  public Dog(int age, String name, String breed)
  {
    super(age, name);
    this.breed = breed;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    if (!super.equals(o))
      return false;
    Dog dog = (Dog) o;
    return Objects.equals(breed, dog.breed);
  }

  @Override public int hashCode()
  {
    return Objects.hash(super.hashCode(), breed);
  }

  @Override public String toString()
  {
    return "Dog{" + "breed='" + breed + '\'' + '}';
  }

  public String speak()
  {
    return "bjork";
  }
}
