package VehicleList;

public class VehicleList
{
  private Car[] cars;
  private int size;

  public VehicleList(int Maxsize)
  {
    this.size = size;
    cars = new Car[Maxsize];
  }

  public int size()
  {
    return size;
  }

  public boolean isFull()
  {
    for (int i = 0; i < cars.length; i++)
    {
      if (cars[i] == null)
      {
        return false;
      }
    }
    return true;
  }

  public void add(Car vehicle)
  {
    for (int i = 0; i < cars.length; i++)
    {
      if (cars[i] == null)
      {
        cars[i] = vehicle;
      }
    }
  }

  public void remove(Car vehicle)
  {
    for (int i = 0; i < cars.length; i++)
    {
      if (cars[i].equals(vehicle))
      {
        cars[i] = null;
      }
    }
  }

  public Car get(int index)
  {
    return cars[index];
  }

  public int getNumberOfCarsByMake(String make)
  {
    int number = 0;
    for (int i = 0; i < cars.length; i++)
    {
      if (cars[i].getMake().equals(make))
      {
        number++;
      }
    }
    return number;
  }

  public int getNumberOfCarsWithManualGear()
  {
    int number = 0;
    for (int i = 0; i < cars.length; i++)
    {
      if (cars[i].hasManualGear())
      {
        number++;
      }
    }
    return number;
  }

  public int getNumberOfDieselCars()
  {
    int number = 0;
    for (int i = 0; i < cars.length; i++)
    {
      if (cars[i].getEngine().isDiesel())
      {
        number++;
      }
    }
    return number;
  }

  public Car[] getCarsByMake(String make)
  {
    Car[] temp = new Car[getNumberOfCarsByMake(make)];
    for (int i = 0; i < cars.length; i++)
    {
      if (cars[i].equals(make))
      {
        for (int x = 0; x < temp.length; ++x)
        {
          if (temp[x] == null)
          {
            temp[x] = cars[i];
          }
        }
      }
    }
    return temp;
  }

  public Car[] getCarsByGearType(boolean manualGear)
  {
    Car[] temp = new Car[getNumberOfCarsWithManualGear()];
    for (int i = 0; i < cars.length; i++)
    {
      if (cars[i].hasManualGear())
      {
        for (int x = 0; x < temp.length; ++x)
        {
          if (temp[x] == null)
          {
            temp[x] = cars[i];
          }
        }
      }
    }
    return temp;
  }

  public Car getFirstCarByHorsePower(int minHorsePower)
  {
    for (int i = 0; i < cars.length; i++)
    {
      if (cars[i].getEngine().getHorsePower() > minHorsePower)
      {
        return cars[i];
      }
    }
    return null;
  }

  public Car getFastestCar()
  {
    int temp = 0;
    for (int i = 0; i < cars.length; i++)
    {
      if (cars[i].getEngine().getHorsePower() > temp)
      {
        temp = cars[i].getEngine().getHorsePower();
      }
    }
    for (int i = 0; i < cars.length; i++)
    {
      if (temp == cars[i].getEngine().getHorsePower())
      {
        return cars[i];
      }
    }
    return null;
  }
}
