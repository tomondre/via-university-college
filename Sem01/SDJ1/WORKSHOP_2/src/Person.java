public class Person
{
  private String name;
  private Pet pet;

  public Person(String name)
  {
    this.name = name;
  }
  public String getName()
  {
    return name;
  }
  public Pet getPet()
  {
    return pet;
  }
  public String getPetsName()
  {
    return pet.getName();
  }
  @Override public String toString()
  {
    return "Person{" + "name='" + name + '\'' + ", pet=" + pet + '}';
  }
}
