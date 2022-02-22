public class Pet
{
 private String name, type;
public Pet(String type, String name)
{
  this.type = type;
  this.name = name;
}
public Pet(String type)
{
  this.type= type;
  name = "";
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
  public static String getCollar()
  {
return "I m someones pet";
  }
public boolean equals(Pet pet2)
{
  if (name.equals(""))
  {
    if (type.equals(pet2.type))
    {
      return true;
    }
    else return false;
  }
  else{
    if (type.equals(pet2.type)&&name.equals(pet2.name))
    {
      return true;
    }
    else return false;
  }
}
  @Override public String toString()
  {
    return "Pet{" + "name='" + name + '\'' + ", type='" + type + '\'' + '}';
  }
}
