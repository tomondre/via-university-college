package KinderGarden;

import java.util.ArrayList;

public class Kindergarten
{
  private int countTeacher;
  private ArrayList<Child> list;

  public Kindergarten()
  {
    countTeacher = 0;
    list = new ArrayList<Child>();
  }

  public void addChild(Child child)
  {
    list.add(child);
  }

  public void removeChild(Child child)
  {
    list.remove(child);
  }

  public void hireTeachers(int count)
  {
    countTeacher += count;
  }

  public void fireTeacher()
  {
    countTeacher--;
  }

  public int countChildren()
  {
    return list.size();
  }

  public int countTeacher()
  {
    return countTeacher;
  }

  public double getNorm()
  {
    return list.size() / countTeacher;
  }

  public double getAverageChildAge()
  {
    int temp = 0;
    for (int i = 0; i < list.size(); i++)
    {
      temp += list.get(i).getAge();
    }
    return temp;
  }

  @Override public String toString()
  {
    return "Kindergarten{" + "countTeacher=" + countTeacher + ", list=" + list
        + '}';
  }

}
