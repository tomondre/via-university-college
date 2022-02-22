package Car;

import java.io.Serializable;
import java.util.ArrayList;

public class CarList implements Serializable
{
  private ArrayList<Car> cars;

  public CarList()
  {
    cars = new ArrayList<Car>();
  }

  public int size()
  {
    return cars.size();
  }

  public int indexOfRegNumber(String regNum)
  {
    for (int i = 0; i < cars.size(); i++)
    {
      if (cars.get(i).getRegNumber().equals(regNum))
      {
        return i;
      }
    }
    return -1;
  }

  public Car getCar(int index)
  {
    return index<cars.size()?cars.get(index):null;
  }

  public Car getCar(String regNum)
  {
    return cars
        .get(indexOfRegNumber(regNum) == -1 ? null : indexOfRegNumber(regNum));
  }

  public void addCar(Car car)
  {
    if (indexOfRegNumber(car.getRegNumber())==-1)
    {
      cars.add(car);
    }
//    boolean foundMatch = false;
//    for (Car ca : cars)
//    {
//      if (ca.getRegNumber().equals(car.getRegNumber()))
//      {
//        foundMatch = true;
//        break;
//
//      }
//    }
//    if (!foundMatch)
//    {
//      cars.add(car);
//    }
  }

  public String toString()
  {
    String temp = "";
    for (Car car : cars)
    {
      temp += car + "\n";
    }
    return temp;
  }

}