public class Student
{
  String name;
  char gender;
  int id;

  public Student(String name, char gender, int id)
  {
    this.name = name;
    this.gender = gender;
    this.id = id;
  }

  public Student(String name, char gender)
  {
    this.name = name;
    this.gender = gender;
    id = 0;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public char getGender()
  {
    return gender;
  }

  public int getId()
  {
    return id;
  }
  public String toString()
  {
    return "Student{" + "name='" + name + '\'' + ", gender=" + gender + ", id="
        + id + '}';
  }
}
