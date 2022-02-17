import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise_2
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    Scanner read = null;
    try
    {
      FileInputStream fileIn = new FileInputStream(keyboard.nextLine());
      read = new Scanner(fileIn);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found, or could not be opened");
      System.exit(1);
    }
    while (read.hasNext())
    {

      System.out.println(read.nextLine());
    }
    read.close();
  }
}
