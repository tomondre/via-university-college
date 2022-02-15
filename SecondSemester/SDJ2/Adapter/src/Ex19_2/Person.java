package Ex19_2;

public class Person
{
  private String name;
  private String dob;
  private int ssn;

  public Person(String name, String dob, int ssn)
  {
    this.name = name;
    this.dob = dob;
    this.ssn = ssn;
  }

  public String getName()
  {
    return name;
  }

  public String getDob()
  {
    return dob;
  }

  public int getSsn()
  {
    return ssn;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setDob(String dob)
  {
    this.dob = dob;
  }

  public void setSsn(int ssn)
  {
    this.ssn = ssn;
  }

  @Override public String toString()
  {
    return "Person{" + "name='" + name + '\'' + ", dob='" + dob + '\''
        + ", ssn=" + ssn + '}';
  }
}
