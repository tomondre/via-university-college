package Course;

public class Student
{
  private String name;
  private  int semester;
  public Student(String name, int semester)
  {
    this.name = name;
    this.semester = semester;
  }
  public String getName()
  {
    return name;
  }
public int getSemester()
{
  return semester;
}
public boolean equals(Object obj)
{
  if(!(obj instanceof Student))
  {
    return false;
  }
  Student other = (Student)obj;
  return name.equals(other.name)&&semester==other.semester;
}

  @Override public String toString()
  {
    return "Student{" + "name='" + name + '\'' + ", semester=" + semester + '}';
  }
}
