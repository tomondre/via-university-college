package Car;
import FileIO.MyFileIO;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CarFileAdapter
{
  private String fileName;
  private MyFileIO mfio;

  public CarFileAdapter(String fileName)
  {
    mfio = new MyFileIO();
    this.fileName = fileName;

  }

  public CarList getAllCars()
  {
    CarList cars = new CarList();
    try
    {
      cars = (CarList)mfio.readObjectFromFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File Not Found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return cars;
  }

  public void addCar(Car car)
  {
    CarList cars = getAllCars();
    cars.addCar(car);
    saveChanges(fileName, cars);
  }

  public void addCars(CarList cars)
  {
    CarList carrs = getAllCars();
    for(int i = 0;i<carrs.size();i++)
    {
      carrs.addCar(cars.getCar(i));
    }
    saveChanges(fileName,carrs);
  }

  public void deleteCar(Car car)
  {
    deleteCarByRegNumber(car.getRegNumber());
  }

  public void deleteCarByRegNumber(String regNo)
  {
    CarList cars = getAllCars();
    CarList temp2 = new CarList();
    for (int i = 0; i < cars.size(); i++)
    {
      if(!(cars.getCar(i).getRegNumber().equals(regNo)))
      {
        temp2.addCar(cars.getCar(i));
      }
    }
    saveChanges(fileName,temp2);
  }

  public void saveChanges(String fileName, CarList cars)
  {
    try
    {
      mfio.writeToFile(fileName, cars);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File Not Found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
  }

}


