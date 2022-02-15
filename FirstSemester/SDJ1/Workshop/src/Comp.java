public class Comp
{
private Website website;
private String name, address;
 public Comp(String name, String address)
 {
   this.name = name;
   this.address = address;
 }
public void createWebsite(Website website)
{
  this.website = website;
}
public  String getUrl(){
   return website.getUrl();
}
  public String getName()
  {
    return name;
  }
  public String getAddress()
  {
    return address;
  }
  @Override public String toString()
  {
    return "Comp{" + "name='" + name + '\'' + ", address='" + address + '\''
        + '}';
  }
}
