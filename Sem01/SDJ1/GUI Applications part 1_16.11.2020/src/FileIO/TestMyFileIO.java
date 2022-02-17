package FileIO;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestMyFileIO
{
   public static void main(String[] args)
   {
      Student[] students = new Student[4];

      students[0] = new Student("Allan", "Henriksen", "Denmark");
      students[1] = new Student("Bob", "Bobson", "England");
      students[2] = new Student("Carl", "Carlson", "Iceland");
      students[3] = new Student("Dave", "Daveson", "England");
  
      MyFileIO mfio = new MyFileIO();
      try
      {
         mfio.writeToFile("Test.bin", students);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }

      System.out.println("Done writing");

      Object[] result = null;

      try
      {
         result = mfio.readArrayFromFile("Test.bin");
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }

      for (int i = 0; i < result.length; i++)
      {
         System.out.println(result[i]);
      }
   }
}
