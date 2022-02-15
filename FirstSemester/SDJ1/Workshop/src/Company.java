public class Company
{
  private String name, ownersName;
private int employees;
private Adress adress;
public Company(String name, String ownersName, int employees)
{
  this.employees = employees;
  this.name = name;
  this.ownersName = name;
  }
  public Company (String name, String ownersName, int employees, Adress adress)
  {
    this.employees = employees;
    this.name = name;
    this.ownersName = name;
this.adress = adress;
  }
  public String getName()
  {
    return name;
  }
  public Adress getAdress()
  {
    return adress;
  }
  public int getEmployees()
  {
    return employees;
  }
  public String getOwnersName()
  {
    return ownersName;
  }

  @Override public String toString()
  {
    return "Company{" + "name='" + name + '\'' + ", ownersName='" + ownersName
        + '\'' + ", employees=" + employees + ", adress=" + adress + '}';
  }
}
