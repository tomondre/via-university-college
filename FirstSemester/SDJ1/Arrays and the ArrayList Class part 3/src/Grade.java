public class Grade
{
  private String name;
  private int grade;

  public Grade(String courseName, int grade)
  {
    this.name = courseName;
    this.grade = grade;

  }

  public String getCourseName()
  {
    return name;
  }

  public int getGrade()
  {
    return grade;
  }

  public void setCourseName(String name)
  {
    this.name = name;
  }

  public void setGrade(int grade)
  {
    this.grade = grade;
  }
    public String toString(){
    return "Grade: " + grade + "Name" + name;
    }
}
