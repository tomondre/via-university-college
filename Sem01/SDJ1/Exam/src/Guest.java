public class Guest
{
  String name;
  public Guest(String name)
  {
    this.name = name;
  }
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Override public String toString()
  {
    return "Guest{" + "name='" + name + '\'' + '}';
  }
}
