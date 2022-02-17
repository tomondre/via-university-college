package Student;

public class Student
{
  private String name;
  private int grade;

  public Student(String name, int grade)
  {
    this.name = name;
    if (grade != -3 && grade != 0 && grade != 2 && grade != 4 && grade != 7
        && grade != 10 && grade != 12)
    {
      throw new NullPointerException("Not a danish grade");
    }
    this.grade = grade;
  }

  public String getName()
  {
    return name;
  }

  public int getGrade()
  {
    return grade;
  }

  public void setGrade(int grade)
  {
    this.grade = grade;
  }

  public String toString()
  {
    return "Name: " + name + ", grade:" + grade;
  }

  public static void main(String[] args)
  {
    Student s1 = new Student("Tomas", 0);
    Student s2 = new Student("mas", 2);
    System.out.println("22");
    try
    {
      s2.setGrade(1);
    }
    catch(Exception IllegalGradeException)
    {
      System.out.println(s2.getGrade());
    }
    System.out.println(s1);
  }

}
