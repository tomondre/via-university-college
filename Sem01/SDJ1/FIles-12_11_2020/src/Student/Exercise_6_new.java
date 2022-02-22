package Student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_6_new
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    Scanner read = null;
    ArrayList<Student> list = new ArrayList<Student>();
    list.add(new Student("Bob", "Bobson", "Denmark"));
    list.add(new Student("Jane", "Doe", "England"));
    list.add(new Student("John", "Doe", "USA"));
    try
    {
      FileInputStream fileIn = new FileInputStream("Template.html");
      read = new Scanner(fileIn);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found, or could not be opened");
      System.exit(1);
    }
    System.out.println("Text in file:");
    ArrayList<String> lines = new ArrayList<String>();
    while (read.hasNext())
    {
      lines.add(read.nextLine());
    }
    read.close();
    for (int i = 0; i<lines.size();i++)
    {
      if (lines.get(i).contains("$title"))
      {
        lines.set(i,lines.get(i).replace("$title", "Student List"));
      }
      if (lines.get(i).contains("$header"))
      {
        lines.set(i,lines.get(i).replace("$header", "Student List"));
      }
      if (lines.get(i).contains("$paragraph1"))
      {
        lines.set(i,lines.get(i).replace("$paragraph1", "This is a student list example"));
      }
      if (lines.get(i).contains("$tableHeader1"))
      {
        lines.set(i,lines.get(i).replace("$tableHeader1", "Name"));
      }
      if (lines.get(i).contains("$tableHeader2"))
      {
        lines.set(i,lines.get(i).replace("$tableHeader2", "Country"));
      }
      if (lines.get(i).contains("$tableData"))
      {
        lines.remove(i);
        int temp = i;
        for (int j = 0; j < list.size(); j++)
        {
          lines.add(temp + j,
              "<tr><td>" + list.get(j).getFirstName() + " " + list.get(j)
                  .getLastName() + "</td><td>" + list.get(j).getCountry()
                  + "</td></tr>");
        }
      }
    }
    PrintWriter write = null;
    try
    {
      FileOutputStream fileOut = new FileOutputStream("newStudent.html");
      write = new PrintWriter(fileOut);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found, or could not be opened");
      System.exit(1);
    }
    for(String str:lines)
    {
      write.println(str);
    }
    write.close();
  }
}