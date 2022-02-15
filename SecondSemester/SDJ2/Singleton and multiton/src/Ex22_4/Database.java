package Ex22_4;

import java.util.ArrayList;

public class Database
{
  private ArrayList<Car> cars;
  private ArrayList<Customer> customers;
  private static Database instance = new Database();

  private Database()
  {
    cars = new ArrayList<Car>();
    customers = new ArrayList<Customer>();
  }

  public Car getCar(String licensePlate)
  {
    for (Car car : cars)
    {
      if (car.getLicensePlate().equals(licensePlate))
      {
        return car;
      }
    }
    return null;
  }

  public Customer getCustomer(String SSN)
  {
    for (Customer customer : customers)
    {
      if (customer.getSSN().equalsIgnoreCase(SSN))
      {
        return customer;
      }
    }
    return null;
  }

  public static Database getInstance()
  {
    return instance;
  }
}
