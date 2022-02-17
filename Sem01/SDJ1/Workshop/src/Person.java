public class Person
{
  private String name;
  private Pet pet;
  public Person(String name)
  {
  this.pet = null ;
    this.name = name;
  }
  public String getName()
  {
    return name;
  }
  public void setPet(Pet pet)
  {
    this.pet = pet;
  }
  public Pet getPet()
  {
    return pet;
  }
  public String getPetName()
  {
    return getName();
  }
  @Override public String toString()
  {
    return "Person{" + "name='" + name + '\'' + ", pet=" + pet + '}';
  }
}
