package Animal;

public abstract class Pet extends Animal
{
  private String name;

  public Pet(int age, String name)
  {
    super(age);
    this.name = name;
  }

}
