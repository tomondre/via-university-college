package Apartment;

public class Tenant
{
  private String name;
  private MyDate mydate;

  public Tenant(String name)
  {
    this.name = name;
    mydate = null;
  }

  public String getName()
  {
    return name;
  }
  public MyDate getRentedFrom()
  {
    return mydate.copy();
  }
  public void setRentedFrom(MyDate mydate)
  {
    this.mydate = mydate.copy();
  }
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Tenant))
    {
      return false;
    }
    Tenant other = (Tenant) obj;

    return mydate.equals(other.mydate)&&name.equals(other.name);

  }

  @Override public String toString()
  {
    return "Tenant{" + "name='" + name + '\'' + ", mydate=" + mydate + '}';
  }
}
