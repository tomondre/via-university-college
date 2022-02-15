package FileIO;

import java.io.FileNotFoundException;

public class TestMyTextFileIO
{
   public static void main(String[] args)
   {
      MyTextFileIO mtfio = new MyTextFileIO();
      try
      {
         mtfio.writeToFile("Test.txt", "Hello");
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }

      String[] strings = { "Just", "some", "more", "strings" };

      try
      {
         mtfio.appendToFile("Test.txt", strings);
      }
      catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
 
      String[] result = null;
      try
      {
         result = mtfio.readArrayFromFile("Test.txt");
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }

      for (int i = 0; i < result.length; i++)
      {
         System.out.println(result[i]);
      }
   }
}
