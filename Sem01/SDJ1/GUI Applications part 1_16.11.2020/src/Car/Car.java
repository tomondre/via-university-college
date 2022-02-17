package Car;

import java.io.Serializable;

public class Car implements Serializable
{
  private String regNumber, make, model, year;
  private Owner owner;

  public Car(String regNumber, String make, String model, String year,
      Owner owner)
  {
    this.regNumber = regNumber;
    this.make = make;
    this.model = model;
    this.year = year;
    this.owner = owner;
  }

  public String getRegNumber()
  {
    return regNumber;
  }

  public String getMake()
  {
    return make;
  }

  public String getModel()
  {
    return model;
  }

  public String getYear()
  {
    return year;
  }

  public Owner getOwner()
  {
    return owner;
  }

  public String toString()
  {
    return "Owner: " + owner + ", regNumber: " + regNumber + ", year: " + year
        + ", make: " + make + ", model" + model;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Car))
    {
      return false;
    }
    Car other = (Car) obj;
    return owner.equals(other.owner) && regNumber.equals(other.regNumber)
        && make.equals(other.make) && model.equals(other.model)
        && year == other.year;
  }


}
