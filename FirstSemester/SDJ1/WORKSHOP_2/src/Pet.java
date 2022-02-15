import java.util.Objects;

public class Pet
{
  private String name;
  private String type;

  public Pet(String name, String type)
  {
    this.name = name;
    this.type = type;
  }
  public Pet(String type)
  {
    this.type = type;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public String getName()
  {
    return name;
  }
  public String getType()
  {
    return type;
  }
  public static String  getColar(){
    return "I m someonepet!";
  }
  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Pet pet = (Pet) o;
    return Objects.equals(name, pet.name) && Objects.equals(type, pet.type);
  }
  @Override public String toString()
  {
    return "Pet{" + "name='" + name + '\'' + ", type='" + type + '\'' + '}';
  }
}