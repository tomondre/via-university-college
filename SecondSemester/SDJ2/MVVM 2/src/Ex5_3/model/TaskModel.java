package Ex5_3.model;

import Ex5_1.model.PropertyChangeSubject;

import java.util.ArrayList;

public interface TaskModel extends PropertyChangeSubject
{
  void addTask(String owner, String description);
  Task getNextTask();
  ArrayList<Task> getTasks();
}

