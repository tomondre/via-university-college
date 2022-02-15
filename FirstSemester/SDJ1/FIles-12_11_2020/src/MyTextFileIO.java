import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MyTextFileIO
{
  public void writeToFile(String fileName, String str)
      throws FileNotFoundException
  {

    FileOutputStream fileOut = new FileOutputStream(fileName);
    PrintWriter write = new PrintWriter(fileOut);
    write.write(str);
    write.close();
  }

  public void appendToFile(String fileName, String str)
      throws FileNotFoundException
  {
    FileOutputStream fileOut = new FileOutputStream(fileName, true);
    PrintWriter write = new PrintWriter(fileOut);
    write.write(str);
    write.close();
  }

  public void writeToFile(String fileName, String[] strs)
      throws FileNotFoundException
  {
    FileOutputStream fileOut = new FileOutputStream(fileName);
    PrintWriter write = new PrintWriter(fileOut);
    for (String str : strs)
    {
      write.write(str);
    }
    write.close();
  }

  public void appendToFile(String fileName, String[] strs)
      throws FileNotFoundException
  {

    FileOutputStream fileOut = new FileOutputStream(fileName, true);
    PrintWriter write = new PrintWriter(fileOut);
    for (String str : strs)
    {
      write.write(str);
    }
    write.close();
  }

  public String readStringFromFile(String fileName) throws FileNotFoundException
  {
    String temp = "";
    FileInputStream fileIn = new FileInputStream(fileName);
    Scanner read = new Scanner(fileIn);
    while (read.hasNext())
    {
      temp += read.nextLine() + "\n";
    }
    return temp;
  }

  public String[] readArrayFromFile(String fileName)
      throws FileNotFoundException
  {
    ArrayList<String> temp = new ArrayList<String>();
    FileInputStream fileIn = new FileInputStream(fileName);
    Scanner read = new Scanner(fileIn);
    while (read.hasNext())
    {
      temp.add(read.nextLine());
    }
    return temp.toArray(new String[temp.size()]);
  }
}