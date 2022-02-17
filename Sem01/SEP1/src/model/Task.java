package model;

import java.io.Serializable;

/**
 * A class of a Task object
 */
public class Task implements Serializable
{
  private int taskID;
  private String description;
  private boolean isDone;
  private double estimatedTime;
  private double timeUsed;
  private MyDate deadline;
  private Employee responsibleEmployee;
  private EmployeeList assignedToTask;

  /**
   * A constructor for creating Task with 8 fields.
   * @param taskID              the unique ID of the Task object
   * @param description         the description of Task object
   * @param estimatedTime       the time estimation of the Task object
   * @param deadline            the MyDate object of the Task object
   * @param timeUsed            the used time og the Task object
   * @param status              the status of the Task object
   * @param responsibleEmployee the Employee object of the Task object
   */
  public Task(int taskID, String description, boolean status, double timeUsed,
      double estimatedTime, MyDate deadline, EmployeeList employees,
      Employee responsibleEmployee)
  {
    this.taskID = taskID;
    this.description = description;
    isDone = status;
    this.timeUsed = timeUsed;
    this.deadline = deadline;
    this.estimatedTime = estimatedTime;
    addTeamMembers(employees);
    this.responsibleEmployee = responsibleEmployee;
  }

  /**
   * Constructor called when copying a Task object.
   *
   * @param taskID              the unique ID of the Task object
   * @param description         the description of Task object
   * @param estimatedTime       the time estimation of the Task object
   * @param deadline            the deadline object of the Task object
   * @param timeUsed            the used time og the Task object
   * @param assignedToTask      the list of Employees assigned to the Task object
   * @param status              the status of the Task object
   * @param responsibleEmployee the Employee object of the Task object
   */
  public Task(int taskID, String description, double estimatedTime,
      MyDate deadline, double timeUsed, EmployeeList assignedToTask,
      boolean status, Employee responsibleEmployee)
  {
    this.taskID = taskID;
    this.description = description;
    this.timeUsed = timeUsed;
    this.deadline = deadline;
    this.estimatedTime = estimatedTime;
    isDone = status;
    this.assignedToTask = assignedToTask;
    this.responsibleEmployee = responsibleEmployee;
  }

  /**
   * Edits fields inside the Task object.
   *
   * @param description         the description of Task object
   * @param estimatedTime       the time estimation of the Task object
   * @param deadline            the deadline of the Task object
   * @param timeUsed            the used time og the Task object
   * @param status              the status of the Task object
   * @param responsibleEmployee the responsible Employee of the Task object
   */
  public void set(String description, boolean status, double timeUsed,
      double estimatedTime, MyDate deadline, EmployeeList employees,
      Employee responsibleEmployee)
  {
    this.description = description;
    isDone = status;
    this.timeUsed += timeUsed;
    this.deadline = deadline;
    this.estimatedTime = estimatedTime;
    this.responsibleEmployee = responsibleEmployee;
    addTeamMembers(employees);
  }

  /**
   * Gets a unique number of the Task object.
   *
   * @return the int with the task number
   */
  public int getTaskID()
  {
    return taskID;
  }

  /**
   * Gets a double representation of the time spent on a Task.
   *
   * @return the double value with time used on a task
   */
  public double getTimeUsed()
  {
    return timeUsed;
  }

  /**
   * Gets a double representation of the Task time estimation.
   *
   * @return the double value with the time estimation
   */
  public double getEstimateTime()
  {
    return estimatedTime;
  }

  /**
   * Gets a String representation of the Task description
   *
   * @return the String with the description
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * Gets a MyDate object representation of the Task deadline
   *
   * @return the MyDate object with the Task deadline
   */
  public MyDate getDeadline()
  {
    return deadline;
  }

  /**
   * Gets a boolean representation of the Task status.
   *
   * @return the boolean with the task status
   */
  public boolean isDone()
  {
    return isDone;
  }

  /**
   * Adds an employees to the Task.
   *
   * @param employees the EmployeeList object containing Employees
   */
  public void addTeamMembers(EmployeeList employees)
  {
    this.assignedToTask = new EmployeeList();
    this.assignedToTask = employees;
  }

  /**
   * Gets an Employee object representation of the Task responsible Employee.
   *
   * @return the Employee object with the Task responsible Employee
   */
  public Employee getResponsibleEmployee()
  {
    return responsibleEmployee;
  }

  /**
   * Gets a List of Employees representation to the Task object
   *
   * @return the EmployeeList object with the employees assigned
   */
  public EmployeeList getAssignedToTask()
  {
    return assignedToTask;
  }

  /**
   * Gets a String representation of the Task object
   *
   * @return the String containing information about Task object
   */
  public String toString()
  {
    return "ID: " + taskID;
  }

  /**
   * Gets a boolean representation of the result after comparing fields from object and the Task
   *
   * @param obj Object containing fields to compare
   * @return the boolean containing result of fields comparison
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Task))
    {
      return false;
    }
    Task other = (Task) obj;
    return taskID == other.taskID && isDone == other.isDone
        && Double.compare(other.estimatedTime, estimatedTime) == 0
        && Double.compare(other.timeUsed, timeUsed) == 0 && description
        .equals(other.description) && deadline.equals(other.deadline)
        && responsibleEmployee.equals(other.responsibleEmployee)
        && assignedToTask.equals(other.assignedToTask);
  }

  /**
   * Gets a copy of an existing Task object.
   *
   * @return new Task object with copied fields.
   */
  public Task copy()
  {
    return new Task(taskID, description, estimatedTime, deadline, timeUsed,
        assignedToTask.copy(), isDone, responsibleEmployee.copy());
  }
}