package Customer;

public abstract class Customer
{
  private String name, address;

  public Customer(String name, String address)
  {
    this.name = name;
    this.address = address;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Customer))
    {
      return false;
    }
    Customer other = (Customer) obj;
    return name.equals(other.address) && address.equals(address);
  }

  @Override public String toString()
  {
    return "Name: " + name + ", address: " + address;
  }

  public abstract String getType();
}
