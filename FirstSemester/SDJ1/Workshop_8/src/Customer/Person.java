package Customer;

public class Person extends Customer
{
  private int ssn;

  public Person(String name, String address, int ssn)
  {
    super(name, address);
    this.ssn = ssn;
  }

  public int getSsn()
  {
    return ssn;
  }

  public String getType()
  {
    return "personal";
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Person))
    {
      return false;
    }
    Person other = (Person) obj;
    return super.equals(other) && ssn == other.ssn;
  }

  public String toString()
  {
    return super.toString() + ", ssn: " + ssn;
  }
}
