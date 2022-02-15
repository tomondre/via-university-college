package Student;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class XML
{
  public static void main(String[] args)
  {
    ArrayList<Student> list = new ArrayList<Student>();
    list.add(new Student("Bob", "Bobson", "Denmark"));
    list.add(new Student("Jane", "Doe", "England"));
    list.add(new Student("John", "Doe", "USA"));
    PrintWriter write = null;
    try
    {
      FileOutputStream fileOut = new FileOutputStream("student.xml");
      write = new PrintWriter(fileOut);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found, or could not be opened");
      System.exit(1);
    }
    System.out.println("Writing the data");
    write.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?> ");
    write.println("<students>");
    for (Student student : list)
    {
      write.println(" <student>");
      write.println("   <firstName>" + student.getFirstName() + "</firstName>");
      write.println("   <lastName>" + student.getLastName() + "</lastName>");
      write.println("   <country>" + student.getCountry() + "</country>");
      write.println(" </student>");
    }
    write.println(" </students>");
    write.close();
  }

}


