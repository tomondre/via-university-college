package model;

import java.io.Serializable;

/**
 * A class of Requirement object
 */
public class Requirement implements Serializable
{
  public static final String APPROVED = "Approved";                           //we have to decide which system of comparing Strings (roles and statuses) we want to use
  public static final String REJECTED = "Rejected";
  public static final String STARTED = "Started";
  public static final String NOT_STARTED = "Not started";
  public static final String ENDED = "Ended";
  public static final String FUNCTIONAL = "Functional";
  public static final String NON_FUNCTIONAL = "Non functional";
  private String requirementId;
  private String description;
  private String status;
  private double estimateTime;
  private int priorityNumber;
  private MyDate deadline;
  private TaskList taskList;
  private Employee responsibleEmployee;
  private String requirementType;

  /**
   * A constructor for creating Requirement with 8 fields.
   *
   * @param requirementId       the unique ID of the Requirement object
   * @param priorityNumber      the priority of the Requirement object
   * @param description         the description of the Requirement object
   * @param estimateTime        the time estimation of the Requirement object
   * @param status              the status of the Requirement object
   * @param requirementType     the type of the Requirement object
   * @param deadline            the MyDate object of the Requirement object
   * @param responsibleEmployee the Employee object of the Requirement object
   */
  public Requirement(String requirementId, int priorityNumber,
      String description, double estimateTime, String status,
      String requirementType, MyDate deadline, Employee responsibleEmployee)
  {
    this.priorityNumber = priorityNumber;
    this.responsibleEmployee = responsibleEmployee;
    taskList = new TaskList();
    this.requirementId = requirementId;
    this.description = description;
    this.estimateTime = estimateTime;
    this.deadline = deadline;
    setRequirementType(requirementType);
    setStatus(status);
  }

  /**
   * A constructor called when copying a Requirement object
   *
   * @param requirementId       the unique ID of the Requirement object
   * @param priorityNumber      the priority of the Requirement object
   * @param description         the description of the Requirement object
   * @param estimateTime        the time estimation of the Requirement object
   * @param status              the status of the Requirement object
   * @param requirementType     the type of the Requirement object
   * @param deadline            the MyDate object of the Requirement object
   * @param responsibleEmployee the Employee object of the Requirement object
   */
  public Requirement(String requirementId, int priorityNumber,
      String description, double estimateTime, String status,
      String requirementType, MyDate deadline, Employee responsibleEmployee,
      TaskList tasks)
  {
    this.priorityNumber = priorityNumber;
    taskList = tasks;
    this.requirementId = requirementId;
    this.description = description;
    this.estimateTime = estimateTime;
    this.deadline = deadline;
    this.status = status;
    this.responsibleEmployee = responsibleEmployee;
    this.requirementType = requirementType;
  }

  /**
   * Edits fields inside the Requirement object.
   *
   * @param priorityNumber      the priority of the Requirement object
   * @param description         the description of the Requirement object
   * @param estimateTime        the time estimation of the Requirement object
   * @param status              the status of the Requirement object
   * @param requirementType     the type of the Requirement object
   * @param deadline            the MyDate object of the Requirement object
   * @param responsibleEmployee the Employee object of the Requirement object
   */
  public void set(int priorityNumber, String description, double estimateTime,
      MyDate deadline, String status, String requirementType,
      Employee responsibleEmployee)
  {
    this.priorityNumber = priorityNumber;
    this.description = description;
    this.estimateTime = estimateTime;
    this.deadline = deadline;
    setStatus(status);
    setRequirementType(requirementType);
    this.responsibleEmployee = responsibleEmployee;
  }

  /**
   * Sets the status field of the Requirement.
   *
   * @param status the status of the Requirement object
   */
  public void setStatus(String status)
  {
    this.status = status;
  }

  /**
   * Sets the type of Requirement.
   *
   * @param requirementType the Requirement Type of the Requirement
   */
  public void setRequirementType(String requirementType)
  {
    this.requirementType = requirementType;
  }

  /**
   * Gets a boolean representation of every Task in TaskList being done.
   *
   * @return the boolean containing information whenever TaskList is done
   */
  public boolean isDone()
  {
    return taskList.isDone();
  }

  //***********************************GETTERS**********************************

  /**
   * Gets a String representation of the Requirement description.
   *
   * @return the String with the description.
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * Gets a double representation of the Requirement time estimation.
   *
   * @return the double with the time estimation
   */
  public double getEstimateTime()
  {
    return estimateTime;
  }

  /**
   * Gets a MyDate object representation of the Requirement deadline
   *
   * @return the MyDate object with the Requirement's deadline
   */
  public MyDate getDeadline()
  {
    return deadline;
  }

  /**
   * Gets a String representation of the Requirement status
   *
   * @return the String with the Requirement's status
   */
  public String getStatus()
  {
    return status;
  }

  /**
   * Gets a String representation of the Requirement type
   *
   * @return the String containing information about Requirement ID
   */
  public String getRequirementType()
  {
    return requirementType;
  }

  /**
   * Gets an Employee object representation of the Requirement responsible Employee.
   *
   * @return the Employee object with the Requirement responsible Employee
   */
  public Employee getResponsibleEmployee()
  {
    return responsibleEmployee;
  }

  /**
   * Gets a boolean representation of the Requirement to be approved.
   *
   * @return the boolean with information whenever Requirement is to be approved based on current Task status
   */
  public boolean toBeApproved()
  {
    return status.equals(ENDED);
  }

  /**
   * Gets a double representation of the total time spent on Requirement object.
   *
   * @return the double with the time used on Requirement tasks
   */
  public double getTotalTimeUsed()
  {
    return taskList.totalTimeUsed();
  }

  /**
   * Gets an int representation of the Requirement priority.
   *
   * @return the int with the priority of the Requirement
   */
  public int getPriority()
  {
    return priorityNumber;
  }

  /**
   * Gets an ID representation of the Requirement ID
   *
   * @return the int with the ID of the requirement
   */
  public String getID()
  {
    return requirementId;
  }

  /**
   * Adds Task object representation to the tasks.
   *
   * @param task the task to be added
   */
  public void addTask(Task task)
  {
    taskList.addTask(task);
  }

  /**
   * Removes a Task object representation with the givenID.
   *
   * @param taskID the id of the Task to be added
   */
  public void removeTask(int taskID)
  {
    taskList.removeTask(taskID);
  }

  //TODO

  /**
   * Gets a Task representation with the given ID.
   *
   * @param taskID
   * @return
   */
  public Task getTaskById(int taskID)
  {
    return taskList.getTaskById(taskID);
  }

  /**
   * Gets a TaskList representation of the Requirement.
   *
   * @return list of Tasks
   */
  public TaskList getTaskList()
  {
    return taskList;
  }

  //****************************************************************************

  /**
   * Check the status of the Requirement.
   */
  public void checkStatus()
  {
    if (isDone() && !(status.equals(APPROVED) || status.equals(REJECTED)))
    {
      status = ENDED;
    }
    else if (isDone() && status.equals(REJECTED))
    {
      status = STARTED;
    }
    else if (isDone() && status.equals(APPROVED))
    {
      status = APPROVED;
    }
  }

  /**
   * Gets a boolean representation of the result after comparing object to the Requirement
   *
   * @param obj Object containing fields to compare
   * @return the boolean information containing result of fields comparison
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Requirement))
    {
      return false;
    }
    Requirement other = (Requirement) obj;
    return this.requirementId.equals(other.requirementId) && this.description
        .equals(other.description) && this.status.equals(other.status)
        && this.estimateTime == other.estimateTime
        && this.priorityNumber == other.priorityNumber && this.deadline
        .equals(other.deadline) && this.responsibleEmployee
        .equals(other.responsibleEmployee) && this.requirementType
        .equals(other.requirementType);
  }

  /**
   * Gets a String representation of the Requirement
   *
   * @return the String containing information about Requirement
   */
  public String toString()
  {
    //checkStatus();
    return "ID: " + requirementId + " -  Pr: " + priorityNumber;
  }

  /**
   * Gets a copy of an existing Requirement.
   * @return new Requirement object with copied fields
   */
  public Requirement copy()
  {
    return new Requirement(requirementId, priorityNumber, description,
        estimateTime, status, requirementType, deadline,
        responsibleEmployee.copy(), taskList.copy());
  }
}