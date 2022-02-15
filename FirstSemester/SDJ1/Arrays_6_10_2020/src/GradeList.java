import java.util.Arrays;

public class GradeList
{
  private int[] grades;
  public GradeList(int numberOfGrades){
    grades = new int[numberOfGrades];
  }
  public int getNumberOfGrades()
  {
    return grades.length;
  }
  public int getGrade(int index){
    return grades[index];
  }
  public void setGrade(int grade, int index){
    grades[index] = grade;
  }

  public double getAvarage()
  {
    int sum = 0;
    for (int i = 0; i < grades.length; i++)
    {
      sum+=grades[i];
    }
    return sum/ grades.length;
  }
  /*
  @Override public String toString()
  {
    return grades;
  }

   */
}
