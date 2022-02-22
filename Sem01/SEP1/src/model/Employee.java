package model;

import java.io.Serializable;

/**
 * A class of Employee object
 */
public class Employee implements Serializable
{
  public static final String DEVELOPER = "Developer";
  public static final String SCRUM_MASTER = "Scrum master";
  public static final String PRODUCT_OWNER = "Product owner";
  public static final String PROJECT_CREATOR = "Project creator";
  private int employeeID;
  private String firstName;
  private String lastName;
  private String role;
  private TaskList tasks;

  /**
   * A constructor for creating Employee object
   *
   * @param employeeID the unique ID of the Employee object
   * @param firstName  the first name of the Employee object
   * @param lastName   the last name of the Employee object
   */
  public Employee(int employeeID, String firstName, String lastName)
  {
    this.employeeID = employeeID;
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = "";
    tasks = new TaskList();
  }

  /**
   * A constructor called when copying an Employee object
   *
   * @param employeeID the unique ID of the Employee object
   * @param firstName  the first name of the Employee object
   * @param lastName   the last name of the Employee object
   * @param role       the role of the Employee object
   * @param tasks      tasks the Employee is assigned to
   */
  public Employee(int employeeID, String firstName, String lastName,
      String role, TaskList tasks)
  {
    this.employeeID = employeeID;
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
    this.tasks = tasks;
  }

  /**
   * Sets an ID of the Employee object
   *
   * @param employeeID the unique ID with new Employee Object
   */
  public void setEmployeeID(int employeeID)
  {
    this.employeeID = employeeID;
  }

  /**
   * Sets a first name field of an Employee object
   *
   * @param firstName the String value with new Employee object first name
   */
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  /**
   * Sets a last name field of en Employee object
   *
   * @param lastName the String value with new Employee object last name
   */
  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  /**
   * Sets a role field of an Employee object
   *
   * @param role the String value with new Employee object role
   */
  public void setRole(String role)
  {
    this.role = role;
  }

  /**
   * Gets the String representation of the Employee object first name.
   *
   * @return the String with the first name
   */
  public String getFirstName()
  {
    return firstName;
  }

  /**
   * Gets a String representation of the Employee object last name.
   *
   * @return the String with the last name
   */
  public String getLastName()
  {
    return lastName;
  }

  /**
   * Gets a int with the id of the Employee object
   *
   * @return the ID of the Employee object
   */
  public int getId()
  {
    return employeeID;
  }

  /**
   * Gets a String representation with the role of the Employee object.
   *
   * @return the role of the Employee object
   */
  public String getRole()
  {
    return role;
  }

  /**
   * Adds a Task to the taskList of the Employee object.
   *
   * @param task the Task object
   */
  public void addTask(Task task)
  {
    tasks.addTask(task);
  }

  /**
   * Removes a task from the Employee TaskList object
   *
   * @param task the Task to be deleted from the List.
   */
  public void removeTask(Task task)
  {
    tasks.removeTask(task.getTaskID());
  }

  /**
   * Clears a taskList inside the Employee Object
   */
  public void resetTasks()
  {
    tasks.clear();
  }

  /**
   * Gets TaskList of assigned Task objects to Employee
   *
   * @return the TaskList with Employee Task objects
   */
  public TaskList getWorkingOnTasks()
  {
    return tasks;
  }

  /**
   * Gets a boolean representation of the result after comparing fields from input object and Employee
   *
   * @param obj Object containing fields to compare
   * @return the boolean containing result of field comparison
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Employee))
    {
      return false;
    }
    Employee other = (Employee) obj;
    return employeeID == other.employeeID && firstName.equals(other.firstName)
        && lastName.equals(other.lastName);
  }

  /**
   * Gets a copy of an existing Employee object
   * @return new Employee with copied fields
   */
  public Employee copy()
  {
    return new Employee(employeeID, firstName, lastName, role, tasks.copy());
  }

  /**
   * Gets a String representation of the Employee object
   * @return the String containing the information about Employee object
   */
  public String toString()
  {
    String toAppend = role.equals("") ? "" : "(" + role + ")";
    return firstName + " " + lastName + " " + toAppend;
  }
}
