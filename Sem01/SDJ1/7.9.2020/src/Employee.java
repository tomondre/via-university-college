public class Employee
{
  private int id;
  private String name, department, position;
  public void setName(String n)
  {
    name = n;
  }
  public void setId(int i)
  {
    id = i;
  }  
  public void setPosition(String p)
  {
    position = p;
  }
  public void setDepartment(String d)
  {
    department=d;
  }
  public String getName()
  {
    return name;
  }
  public int getId()
  {
    return id;
  } public String getPosition()
{
  return position;
}
  public String getDepartment()
  {
    return department;
  }
}