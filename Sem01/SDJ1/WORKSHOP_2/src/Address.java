public class Address
{
  private String city, street;
  private int postCode;

  public Address(String city, String street, int postCode)
  {
    this.city = city;
    this.street = street;
    this.postCode = postCode;
  }
  public void setCity(String city)
  {
    this.city = city;
  }
  public void setStreet(String street)
  {
    this.street = street;
  }
  public void setPostCode(int postCode)
  {
    this.postCode = postCode;
  }
  public String getCity()
  {
    return city;
  }
  public String getStreet()
  {
    return street;
  }
  public int getPostCode()
  {
    return postCode;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Address address = (Address) o;
    return postCode == address.postCode && city.equals(address.city) && street
        .equals(address.street);
  }

  @Override public int hashCode()
  {
    return 0;
  }
}
