package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Task objects.
 */
public class TaskList implements Serializable
{
  private ArrayList<Task> tasks;

  /**
   * No-argument constructor initializing the TaskList
   */
  public TaskList()
  {
    tasks = new ArrayList<Task>();
  }

  /**
   * Constructor used in copy method.
   * @param tasks the list of Task objects
   */
  public TaskList(ArrayList<Task> tasks)
  {
    this.tasks = tasks;
  }

  /**
   * Gets double representation of total hours spent on tasks
   * @return the double information containing total hours spent on Task objects
   */
  public double totalTimeUsed()
  {
    double temp = 0;
    for (Task task : tasks)
    {
      temp += task.getTimeUsed();
    }
    return temp;
  }

  /**
   * Gets a boolean representation of every Task being done
   * @return the boolean containing information after comparing every Task's isDone field inside List
   */
  public boolean isDone()
  {
    if (tasks.size() == 0)
    {
      return false;
    }
    for (Task task : tasks)
    {
      if (!task.isDone())
      {
        return false;
      }
    }
    return true;
  }

  /**
   * Adds a Task to the list if there is no other existing Task with the same ID inside List.
   * @param task the task to be added
   */
  public void addTask(Task task)
  {
    for (Task tsk : tasks)
    {
      if (tsk.getTaskID() == task.getTaskID())
      {
        return;
      }
    }
    tasks.add(task);
  }

  /**
   * Gets a Task object with the given ID.
   * @param taskID the id of the Task object to be returned
   * @return the Task object with the given ID
   */
  public Task getTaskById(int taskID)
  {
    for (Task task : tasks)
    {
      if (task.getTaskID() == taskID)
      {
        return task;
      }
    }
    return null;
  }

  /**
   * Removes a Task object with the given ID.
   * @param taskID the id of the Task object to be removed
   */
  public void removeTask(int taskID)
  {
    tasks.remove(getTaskById(taskID));
  }

  /**
   * Gets a copy of an existing TaskList.
   * @return new TaskList with the copies of existing Tasks inside TaskList
   */
  public TaskList copy()
  {
    ArrayList<Task> temp = new ArrayList<Task>();
    for (Task task : tasks)
    {
      temp.add(task.copy());
    }
    return new TaskList(temp);
  }

  /**
   * Gets how many Task objects are inside the TaskList.
   * @return the number of Task objects inside the TaskList
   */
  public int size()
  {
    return tasks.size();
  }

  /**
   * Gets a Task object with the given index.
   * @param index the number with the index of the Task
   * @return the Task with the given index
   */
  public Task get(int index)
  {
    return tasks.get(index);
  }

  //Method we are using when clearing employees working on tasks because we also have tasklist in employee

  /**
   * Removes evey task inside TaskList. Used when clearing TaskLists inside Employees while moving Project to archive.
   */
  public void clear()
  {
    tasks.clear();
  }

  /**
   * Gets a String representation of the TaskList
   * @return the String containing information about all Task objects in the list - each Task object followed by a new line character
   */
  public String toString()
  {
    String temp = "";
    for (Task task : tasks)
    {
      temp += "Task: " + task + "\n";
    }
    return temp;
  }
}
