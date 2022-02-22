import java.util.ArrayList;

public class GradeList
{
  private ArrayList<Grade> grades;

  public GradeList()
  {
      grades = new ArrayList<Grade>();
    }

  public int getNumberOfGrades()
  {
    return grades.size();
  }

  public ArrayList<Grade> getAllGrades()
  {
    return grades;
  }

  public Grade[] getAllGradesAsArray()
  {
    Grade[] AllGrades = new Grade[grades.size()];
    return grades.toArray(AllGrades);

  }

  public void addGrade(Grade grade)
  {
    grades.add(grade);
  }

  public double getAvarage()
  {

    int temp = 0;
    for (int i = 0; i < grades.size(); i++)
    {
      temp += grades.get(i).getGrade();
    }
    return temp / grades.size();
  }

  public String toString()
  {
    return grades.toString();
  }

  public static void main(String[] args)
  {

    Grade g1 = new Grade("SEP", 4);
    Grade g2 = new Grade("SSE", 8);
    Grade g3 = new Grade("SDJ", 10);

    GradeList list = new GradeList();
    list.addGrade(g1);
    list.addGrade(g2);
    list.addGrade(g3);
    System.out.println(list);

    Grade[] temp = list.getAllGradesAsArray();
    for (int i = 0; i < temp.length; i++)
    {
      System.out.println(temp[i] + "\n");

    }

  }
}
