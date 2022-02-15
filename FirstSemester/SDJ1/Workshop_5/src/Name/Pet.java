package Name;

public class Pet
{
private String type;
private Name name;

public Pet(Name name,String type)
{
  this.name = name;
  this.type = type;
}

  public String getType()
  {
    return type;
  }

  public String getName()
  {
    return name.getFullName();
  }

  @Override public String toString()
  {
    return "Pet{" + "type='" + type + '\'' + ", name=" + name + '}';
  }
}

