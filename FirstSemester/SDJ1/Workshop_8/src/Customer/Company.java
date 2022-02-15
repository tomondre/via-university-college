package Customer;

public class Company extends Customer
{

  private String field, ownersName;

  public Company(String name, String address, String fiels, String ownersName)
  {
    super(name, address);
    this.field = field;
    this.ownersName = ownersName;
  }

  public String getField()
  {
    return field;
  }

  public String getOwnersName()
  {
    return ownersName;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Company))
    {
      return false;
    }
    Company other = (Company) obj;
    return super.equals(other) && field.equals(other.field) && ownersName
        .equals(other.ownersName);
  }

  public String getType()
  {
    return "buisness";
  }

  public String toString()
  {
    return super.toString() + ", OwnersName: " + ownersName + ", field: " + field;
  }
}
