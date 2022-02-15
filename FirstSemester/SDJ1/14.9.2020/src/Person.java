import java.time.LocalDate;
import java.time.Period;

public class Person
{
private String name, address;
private MyDate md;

  public Person(String name, String address, MyDate birthday)
  {
    this.name = name;
    this.address = address;
    md = birthday.copy();
  }

  public Person(String name, MyDate md)
  {
    this.name = name;
    this.md = md.copy();
  }
  public Person(MyDate md)
  {
    this.md = md.copy();
  }
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public String getAddress()
  {
    return address;
  }
  public void setAddress(String address)
  {
    this.address = address;
  }
  public MyDate getBirthday()
  {
    return md.copy();
  }
  /*public int getAge(){
    MyDate today = md.today();
    if (md.getMonth()<today.getMonth()){return md.getYear()-today.getYear();}
  else if(md.getMonth() == today.getMonth()){
      if (md.getDay()>today.getDay()){return md.getYear()-today.getYear() - 1;}
    }
return Period(md,)

  }

   */

  public boolean equals(Object obj){
    if (!(obj instanceof MyDate)){
return false;
    }
    Person other = (Person) obj;
    return (name == other.name&&address== other.address&&md== other.md);
  }
  @Override public String toString()
  {
    return "Person{" + "name='" + name + '\'' + ", address='" + address + '\''
        + ", md=" + md + '}';
  }


}
