package Student;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveStudent
{
  public static void main(String[] args)
  {
    try
    {
      FileOutputStream fileOut = new FileOutputStream("obj.bin");
      ObjectOutputStream write = new ObjectOutputStream(fileOut);
      write.writeObject(new Student("Tomas", "Ondrejka", "Slovakia"));
      write.writeObject(new Student("Bob", "Marley", "Jamaica"));
      write.writeObject(new Student("Carl", "Simpson", "America"));
      write.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found, or could not be opened");
      System.exit(1);
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
      System.exit(1);
    }
    System.out.println("Done writing");
  }

}

