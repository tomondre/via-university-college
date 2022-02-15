public class Apartment
{
  private String address;
  private double rent;
  private Tenant tenant;

  public Apartment(String address, double rent)
  {
    this.address = address;
    this.rent = rent;
  }

  public String getAddress()
  {
    return address;
  }

  public void setRent(double rent)
  {
    this.rent = rent;
  }

  public double getRent()
  {
    return rent;
  }

  public void rentTo(String name, String phone)
  {
    tenant = new Tenant(name, phone);
  }

  public void evict()
  {
    tenant = null;
  }

  public boolean isOccupied()
  {
    return tenant != null;

  }

  public Tenant getTenant()
  {
    return tenant;

  }

  public double getRentDue()
  {
    return tenant.getRentDue();

  }

  public void chargeRent()
  {
    if (tenant != null)
    {
      tenant.setRentDue(tenant.getRentDue() + rent);
    }
  }

  public void collectRent(double amount)
  {
    tenant.setRentDue(tenant.getRentDue()-amount);

  }

  public String toString()
  {

    if (tenant == null)
    {
      return "Address " + address + " no tenant ";
    }
    else
    {
      return "Address " + address + " rent: " + rent + tenant;
    }
  }

  public static void main(String[] args)
  {

    Apartment a1 = new Apartment("Mik doh", 500 );
    System.out.println(a1);
    a1.rentTo("Tomas ", "09959595");
    System.out.println(a1);
a1.chargeRent();
    System.out.println(a1);
    a1.collectRent(200);
    System.out.println(a1);

  }



}
