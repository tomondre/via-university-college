package Student;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Exercise_6
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
      FileOutputStream fileOut = new FileOutputStream("student.html");
      write = new PrintWriter(fileOut);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found, or could not be opened");
      System.exit(1);
    }
    System.out.println("Writing the data");
    write.println(
        "<html>\n   <head>\n     <title>Students</title>\n     <style>\n       body\n       {\n         background-color:ghostwhite;\n         color:darkblue;\n       }\n       table,th,td\n       {\n         border:1px solid darkblue;\n       }\n       table\n       {\n         border-collapse:collapse;\n         width:30%;\n       }\n       td\n       {\n         height:40px;\n         text-align:center;\n       }\n       th\n       {\n         background-color:lightblue;\n       }\n     </style>\n   </head>\n   <body>\n <h1>Student List</h1>\n <p>This is a student example</p>\n     <table>\n       <tr><th>Name</th><th>Country</th></tr>");
    for (Student student : list)
    {
      write.println(
          "<tr><td>" + student.getFirstName() + " " + student.getLastName()
              + "</td><td>" + student.getCountry() + "</th></tr>");
    }
    write.println("\n   </table>\n </body>\n</html>");
    write.close();

  }
}


