public class Adress
{
  private String streetName, city;
 private int number, zip;
  public Adress(String streetName, int number, String city, int zip)
  {
    this.city  = city;
    this.streetName = streetName;
    this.number = number;
    this.zip = zip;
  }

  public String getStreetName()
  {
    return streetName;
  }
  public int getNumber()
  {
    return number;
  }
  public String getCity()
  {
    return city;
  }
  public int getZip()
  {
    return zip;
  }

  @Override public String toString()
  {
    return "Adress{" + "streetName='" + streetName + '\'' + ", city='" + city
        + '\'' + ", number=" + number + ", zip=" + zip + '}';
  }
}
