package Apartment;

public class Apartment
{
  private int number;
  private Tenant tenant;

  public Apartment(int number)
  {
    this.number = number;
  tenant = null;
  }

  public int getNumber()
  {
    return number;
  }
  public boolean isAvailable()
  {
    return tenant == null;
  }
  public void rentTo(Tenant tenant, MyDate rentedFrom)
  {
    this.tenant  = tenant;
    tenant.setRentedFrom(rentedFrom);
  }
  public Tenant getTenant()
  {
    return tenant;
  }

  @Override public String toString()
  {
    return "Apartment{" + "number=" + number + ", tenant=" + tenant + '}';
  }
}
