import java.util.Arrays;

public class GradeList
{
  private Grade[] grades;
  public GradeList(int numberOfGrades){
    grades = new Grade[numberOfGrades];
  }
  public GradeList(){
    grades = new Grade[5];
  }
  public Grade getGrade(int index){
    return grades[index];
  }
  public void setGrade(Grade grade, int index){
    if (index<grades.length){
      grades[index]=grade;
    }
  }
    public double getAverage(){
    int sum = 0;
    for (int i=0;i< grades.length;i++)
    {
      sum += grades[i].getGrade();
    }
    return (double) sum/ grades.length;
  }

  @Override public String toString()
  {
    return "GradeList{" + "grades=" + Arrays.toString(grades) + '}';
  }
  public static void main(String[] args){
    Grade g1 = new Grade("Math",2);
    Grade g2 = new Grade("Math",4);
    Grade g3 = new Grade("Math",7);
    GradeList list = new GradeList(3);
    System.out.println(list);
    list.setGrade(g1,0);
    list.setGrade(g2,1);
    list.setGrade(g3,2);

    System.out.println(list.getAverage());
    System.out.println(list);



  }
}
