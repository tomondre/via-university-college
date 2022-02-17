package Vehicle;

public class Car extends Vehicle
{
  private String regNo;

  public Car(String owner, double price, String regNo)
  {
    super(owner, price);
    this.regNo = regNo;
  }

  public String getRegistrationNumber()
  {
    return regNo;
  }

  public void setRegistrationNumber(String regNo)
  {
    this.regNo = regNo;
  }

  public String toString()
  {
    return super.toString() + "regNo : " + regNo;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Car))
    {
      return false;
    }
    Car other = (Car) obj;
    return super.equals(other) && regNo.equals(other.regNo);
  }

}
