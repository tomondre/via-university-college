public class Address
{
  private String street, number, postalCode, city, country;

  public Address(String street, String number, String postalCode, String city,
      String country)
  {
    this.street = street;
    this.number = number;
    this.postalCode = postalCode;
    this.city = city;
    this.country = country;
  }
  public String getStreet()
  {
    return street;
  }
  public String getNumber()
  {
    return number;
  }
  public String getPostalCode()
  {
    return postalCode;
  }
  public String getCity()
  {
    return city;
  }
  public String getCountry()
  {
    return country;
  }
  public void setStreet(String street)
  {
    this.street = street;
  }
  public void setNumber(String number)
  {
    this.number = number;
  }
  public void setPostalCode(String postalCode)
  {
    this.postalCode = postalCode;
  }
  public void setCity(String city)
  {
    this.city = city;
  }
  public void setCountry(String country)
  {
    this.country = country;
  }
  @Override public String toString()
  {
    return "Address{" + "street='" + street + '\'' + ", number='" + number
        + '\'' + ", postalCode='" + postalCode + '\'' + ", city='" + city + '\''
        + ", country='" + country + '\'' + '}';
  }
  public boolean equals(Object obj)

  {
    if (!(obj instanceof Address))
    {
return false;
    }
    Address other = (Address) obj;
    return street.equals(other.street)&&number.equals(other.number)&&
        postalCode.equals(other.postalCode)&&city.equals(other.city)&&
        country.equals(other.country);
  }
}
