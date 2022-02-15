package Car;

public class Car
{
  private String registrationNumber;
  private int mileage;
  private ServiceBook serviceBook;

  public Car(String registrationNumber, int mileage)
  {
    this.registrationNumber = registrationNumber;
    this.mileage = mileage;
    serviceBook = new ServiceBook();
  }

  public String getRegistrationNumber()
  {
    return registrationNumber;
  }

  public int getMileage()
  {
    return mileage;
  }

  public ServiceBook getServiceBook()
  {
    return serviceBook;
  }

  public void setRegistrationNumber(String registrationNumber)
  {
    this.registrationNumber = registrationNumber;
  }

  public void drive(int mileage)
  {
    this.mileage += mileage;
  }

  public void service()
  {
    serviceBook.addService(new Service(0, new Date(26, 10, 2020)));

  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Car))
    {
      return false;
    }
    Car other = (Car) obj;
    return registrationNumber.equals(other.registrationNumber)
        && mileage == other.mileage;
  }
}
