package Car;

public class CarTest
{
  public static void main(String[] args)
  {
    Wheel w1 = new Wheel(25,50);
    Wheel w2 = w1.copy();
    Wheel w3 = w1.copy();
    Wheel w4 = w1.copy();


    Date date = new Date(28,10,2000);
    Car car = new Car("Slovakia","F150","Blue",date);
    Person person = new Person("marek cicala");
    System.out.println(car);
    System.out.println(person);
    person.buyCar(car);
    System.out.println(person);
    person.sellCar();
    System.out.println(person);
    System.out.println(person.getCar());
    person.buyCar(car);

    System.out.println(person.getCar());
    car.setColor("Yellow");
    System.out.println(car);
    System.out.println();

    car.setWheel(w1,1);
    car.setWheel(w2,2);
    car.setWheel(w3,3);
    car.setWheel(w4,4);
    System.out.println(car);
  }
}
