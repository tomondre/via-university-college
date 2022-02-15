package Exercise;

public class Task
{
  private int taskID;
  private int relatedID;
  private String title;
  private String status;
private EmployeeList list;


  public Task(int taskID, int relatedID, String title, String status)
  {
    this.taskID = taskID;
    this.relatedID = relatedID;
    this.title = title;
    this.status = status;
    list = new EmployeeList();
  }

  public void setStatus(String status)
  {
    this.status = status;
  }


}
