package Course;
import java.util.ArrayList;
import java.util.Arrays;

public class Course
{
  private String title;
  private Instructor[] instructor;
  private ArrayList<Student> students;

  public Course(String title, Instructor primaryInstructor)
  {
   this.title = title;
   instructor = new Instructor[2];
   instructor[0] = primaryInstructor;
   instructor[1] = null;
  }
  public String getTitle()
  {
    return title;
  }
  public Instructor getPrimaryInstructor()
  {
    return instructor[0];
  }

  public Instructor getSecondaryInstructor()
  {
    return instructor[1];
  }
  public void setSecondaryInstructor(Instructor instructor)
  {
    this.instructor[1] = instructor;
  }
  public void addStudent(Student student)
  {
    students.add(student);
  }
  public int getNumberOfInstructors()
  {
    int temp = 0;
    for (int i = 0; i < instructor.length; i++)
    {
      if (!(instructor[i]==null))
      {
        temp++;
      }
    }
    return temp;
  }
  public int getNumberOfStudents()
  {
    return students.size();
  }
  public Student[] getStudentsBySemester(int semester)
  {
    ArrayList<Student> temp = new ArrayList<Student>();
    for (int i = 0; i < students.size(); i++)
    {
      if (students.get(i).getSemester()==semester)
      {
        temp.add(students.get(i));
      }
    }
    return temp.toArray(new Student[temp.size()]);
  }
  public boolean hasStudent(String name)
  {
    for (int i = 0; i < students.size(); i++)
    {
      if (students.get(i).getName().equals(name))
      {
        return true;
      }
    }
    return false;
  }

  @Override public String toString()
  {
    return "Course{" + "title='" + title + '\'' + ", instructor=" + Arrays
        .toString(instructor) + ", students=" + students + '}';
  }
}
