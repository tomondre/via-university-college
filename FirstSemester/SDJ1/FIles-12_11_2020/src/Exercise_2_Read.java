import java.io.*;

public class Exercise_2_Read
{
  public static void main(String[] args)
  {
    try
    {
      FileInputStream fileIn = new FileInputStream("test.bin");
      ObjectInputStream read = new ObjectInputStream(fileIn);
      while (true)
      {
        try
        {
          System.out.println(read.readInt());
        }
        catch (EOFException eof)
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
  }
}
