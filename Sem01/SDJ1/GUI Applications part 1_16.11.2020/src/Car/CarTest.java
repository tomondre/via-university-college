package Car;

import FileIO.MyFileIO;
import FileIO.MyTextFileIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class CarTest implements Serializable
{
  public static void main(String[] args)
  {
    CarFileAdapter adapter = new CarFileAdapter("TestStudentFileOuput.bin");
    MyTextFileIO mfio = new MyTextFileIO();
        String[] carArray = null;
        try
        {
          carArray = mfio.readArrayFromFile("TestStudentFile.txt");
          for (int i = 0; i < carArray.length; i++)
          {
            String temp = carArray[i];
            String[] tempArr = temp.split(",");
            adapter.addCar(new Car(tempArr[0], tempArr[1], tempArr[2], tempArr[3],
                new Owner(tempArr[4], tempArr[5])));
          }
        }
        catch (FileNotFoundException e)
        {
          System.out.println("File not found.");
        }


        CarList temp = adapter.getAllCars();

    System.out.println(temp);




    //    Owner owner = new Owner("Tomas", "Ondrejka");
    //    System.out.println(owner);
    //    Owner o2 = new Owner("Tomas", "Ondrejka");
    //    System.out.println(owner.equals(o2));
    //    Car car = new Car("2500", "2000", "25", "1999", owner);
    //    Car c1 = new Car("3000", "2000", "25", "1999", owner);
    //    Car c2 = new Car("2500", "2000", "25", "1999", owner);
    //    CarList list = new CarList();
    //    list.addCar(car);
    //    list.addCar(c1);
    //    list.addCar(c2);
    //    System.out.println(list.getCar("3000"));
    //    System.out.println(list.getCar(1));
    //    System.out.println(list);
    //    System.out.println("------");

//    CarList cars = new CarList();
//    MyTextFileIO mfio = new MyTextFileIO();
//    String[] carArray = null;
//    try
//    {
//      carArray = mfio.readArrayFromFile("TestStudentFile.txt");
//      for (int i = 0; i < carArray.length; i++)
//      {
//        String temp = carArray[i];
//        String[] tempArr = temp.split(",");
//        cars.addCar(new Car(tempArr[0], tempArr[1], tempArr[2], tempArr[3],
//            new Owner(tempArr[4], tempArr[5])));
//      }
//    }
//    catch (FileNotFoundException e)
//    {
//      System.out.println("File not found.");
//    }
//    MyFileIO mfo = new MyFileIO();
//    try
//    {
//      mfo.writeToFile("TestStudentFileOuput.bin",cars);
//    }
//    catch (FileNotFoundException e)
//    {
//      System.out.println("Error openning file");
//    }
//    catch (IOException e)
//    {
//      System.out.println("IO error writing to file");
//    }
//
  }
}