package Ex5_3.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TaskModelManager implements TaskModel
{
  private ArrayList<Task> tasks;
  private PropertyChangeSupport pcs;

  public TaskModelManager()
  {
    tasks = new ArrayList<Task>();
    pcs = new PropertyChangeSupport(this);
  }

  private String calcTimeStamp()
  {
    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date now = new Date();
    return sdfDate.format(now);
  }

  @Override public void addTask(String owner, String description)
  {
    Task taskToAdd = new Task(owner, description, calcTimeStamp());
    tasks.add(taskToAdd);
    pcs.firePropertyChange("TaskAdded", "-1", 0);
    System.out.println(taskToAdd);
  }

  @Override public Task getNextTask()
  {
    if (tasks.size() == 0)
    {
      return null;
    }
    Task temp = tasks.get(0);
    tasks.remove(0);
    pcs.firePropertyChange("TaskGotten", "-1", 0);
    return temp;
  }

  @Override public ArrayList<Task> getTasks()
  {
    return tasks;
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    pcs.addPropertyChangeListener(name, listener);
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    pcs.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    pcs.removePropertyChangeListener(name, listener);
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    pcs.removePropertyChangeListener(listener);
  }
}
