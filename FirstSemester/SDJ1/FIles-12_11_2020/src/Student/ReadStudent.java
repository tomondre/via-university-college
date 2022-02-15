package Student;

import java.io.*;

public class ReadStudent
{
  public static void main(String[] args)
  {
    try
    {
    FileInputStream fileIn = new FileInputStream("obj.bin");
    ObjectInputStream read = new ObjectInputStream(fileIn);
    while(true)
    {
      try
      {
        Student student = (Student)read.readObject();
        System.out.println(student);
      }
      catch(EOFException eof)
      {
        System.out.println("End of title");
        break;
      }
    }
    read.close();
  }
    catch(FileNotFoundException e)
    {
      System.out.println("File not found, or could not be opened");
      System.exit(1);
    }
    catch(IOException e)
    {
      System.out.println("IO Error reading file");
      System.exit(1);
    }
    catch(ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
      System.exit(1);
    }
  }
}
