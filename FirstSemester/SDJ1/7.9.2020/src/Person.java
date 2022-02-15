public class Person
{
  private String name;
  private String birthday;
  public Person()
  { name = "Marek";
  birthday= "28.10.2000"; }

  public Person(String n, String b)
  {
    name = n;
    birthday = b;
  }
  public void setName(String n)
  {
  name = n;
  }
  public void setBirthday(String b)
  {
  birthday = b;
  }
  public String getName()
  {
    return name;
  }
  public String getBirthday()
  {
    return birthday;
  }
  public String toString()
  {
    return "Name = " + name + " birthday = " + birthday;
  }
}
