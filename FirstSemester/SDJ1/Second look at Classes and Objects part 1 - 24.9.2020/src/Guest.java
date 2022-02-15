import java.util.Objects;

public class Guest
{
  private String name;
  private long phone;

  public Guest(String name, long phone){
this.name = name;
this.phone = phone;
  }
  public String getName()
  {
    return name;
  }
  public long getPhone()
  {
    return phone;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public void setPhone(long phone)
  {
    this.phone = phone;
  }
  public boolean equals(Guest guest) {
    if (name == guest.name&&phone ==guest.phone){
      return true;
    }
    else return false;
  }
  @Override public String toString()
  {
    return "Guest{" + "name='" + name + '\'' + ", phone=" + phone + '}';
  }
}
