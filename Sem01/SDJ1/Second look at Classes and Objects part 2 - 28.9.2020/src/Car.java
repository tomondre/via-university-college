import java.util.Objects;

public class Car
{
  private String make, model, color, licenseNumber;
  private int year;

  public Car(String make, String model, String color, String licenseNumber,
      int year)
  {
    this.make = make;
    this.model = model;
    this.color = color;
    this.licenseNumber = licenseNumber;
    this.year = year;
  }
  public Car(String make, String model, String color, int year)
  {
    this.make = make;
    this.model = model;
    this.color = color;
    this.year = year;
    this.licenseNumber = "None";
  }
  public String getMake()
  {
    return make;
  }
  public String getModel()
  {
    return model;
  }
  public String getColor()
  {
    return color;
  }
  public String getLicenseNumber()
  {
    return licenseNumber;
  }
  public int getYear()
  {
    return year;
  }
  public void setColor(String color)
  {
    this.color = color;
  }
  public void setLicenseNumber(String licenseNumber)
  {
    this.licenseNumber = licenseNumber;
  }
  public Car copy(){
    return new Car(make, model,color,licenseNumber,year);
  }
  @Override public String toString()
  {
    return "Car{" + "make='" + make + '\'' + ", model='" + model + '\''
        + ", color='" + color + '\'' + ", licenseNumber='" + licenseNumber
        + '\'' + ", year=" + year + '}';
  }
public boolean equals(Car o)
  {
   return (make.equals(o.make)&&model.equals(o.model)&&color.equals(o.color)&&licenseNumber.equals(o.licenseNumber)&& year == o.year);
  }

}

