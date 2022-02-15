package Car;

public class Person
{
  private Car car;
  private String name;
  public Person(String name)
  {
    this.name = name;
  }
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public void buyCar(Car car){
    this.car = car;
  }
  public void sellCar(){
    car = null;
  }
  public Car getCar()
  {
    return car;
  }
  @Override public String toString()
  {
    return car==null?" name: " + name +  " has no car!":"car: " + car + " owner: " + name;
  }
}
