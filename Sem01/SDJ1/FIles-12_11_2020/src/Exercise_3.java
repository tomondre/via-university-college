import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Scanner;

public class Exercise_3
{
  public static void main(String[] args)
  {
    Random ran = new Random();
    Scanner keyboard = new Scanner(System.in);
    try
    {
      FileOutputStream fileOut = new FileOutputStream("test.bin");
      ObjectOutputStream write = new ObjectOutputStream(fileOut);
      int ii = keyboard.nextInt();
      for (int i = 0; i < ii; i++)
      {
        write.writeInt(ran.nextInt(100));
      }
      write.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found, or could not be opened.");
      System.exit(1);
    }

    catch (IOException e)
    {
      System.out.println("IO Error writing to file ");
      System.exit(1);
    }
  }
}