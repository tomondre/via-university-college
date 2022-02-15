public class Car
{
  int yearModel;
  int speed = 0;
  String make;
  public Car(int yearModel, String make, int speed)
  {
    this.yearModel = yearModel;
    this.make = make;
    this.speed = speed;
  }

  public int getSpeed()
  {
    return speed;
  }

  public int getYearModel()
  {
    return yearModel;
  }

  public String getMake()
  {
    return make;
  }
  public void Accelerate()
    {
    speed=speed +5;
    System.out.println("Speed: " + speed);
  }
  public void Brake()
    {
    speed=speed -5;
    System.out.println("Speed: " + speed);

  }

  public String toString()
  {
    return "Car{" + "yearModel=" + yearModel + ", speed=" + speed + ", make='"
        + make + '\'' + '}';
  }
}
