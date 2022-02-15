package Ex5_3.model;

public class Task
{
  private String owner;
  private String description;
  private String timeCreated;

  public Task(String owner, String description, String timeCreated)
  {
    this.owner = owner;
    this.description = description;
    this.timeCreated = timeCreated;
  }

  public String getOwner()
  {
    return this.owner;
  }

  public String getDescription()
  {
    return this.description;
  }

  public String getTimeCreated()
  {
    return this.timeCreated;
  }

  @Override public String toString()
  {
    return "Task{" + "owner='" + owner + '\'' + ", description='" + description
        + '\'' + ", timeCreated='" + timeCreated + '\'' + '}';
  }
}
