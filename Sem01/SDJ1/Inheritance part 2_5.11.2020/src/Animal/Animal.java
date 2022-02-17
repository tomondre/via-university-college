package Animal;

import java.util.Objects;

public abstract class Animal
{
  private int age;

  public Animal(int age){
    this.age = age;
  }

  @Override public String toString()
  {
    return "Animal{" + "age=" + age + '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Animal animal = (Animal) o;
    return age == animal.age;
  }

  @Override public int hashCode()
  {
    return Objects.hash(age);
  }

  public abstract String speak();

}
