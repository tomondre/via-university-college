import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise_1
{
  public static void main(String[] args)
  {
    PrintWriter write = null;
    Scanner keyboard = new Scanner(System.in);
    try
    {
      FileOutputStream fileOut = new FileOutputStream(keyboard.nextLine());
      write = new PrintWriter(fileOut);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found, or could be not opened");
      System.exit(1);
    }
    String temp = "";
    while (!temp.equals("DONE"))
    {
      temp = keyboard.nextLine();
      if (!temp.equals("DONE"))
      {
        System.out.println(temp);
        write.println(temp);
      }
    }
    write.close();
    System.out.println("Done");
  }

}
