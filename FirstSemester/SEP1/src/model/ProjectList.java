package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class of ProjectList containing Project objects
 */
public class ProjectList implements Serializable
{
  private ArrayList<Project> projects;

  /**
   * No-argument constructor initializing ProjectList
   */
  public ProjectList()
  {
    projects = new ArrayList<Project>();
  }

  /**
   * Adds a Project object to the list if there is no other existing Project with the same unique name
   * @param project the Project to be added
   */
  public void addProject(Project project)
  {
    for (Project p : projects)
    {
      if (p.getName().equals(project.getName()))
      {
        throw new IllegalArgumentException("Project already exists");
      }
    }
    projects.add(project);
  }

  /**
   * Gets a Project object with the given Project name.
   * @param projectName the name of Project in the list
   * @return the Project with the given name
   */
  public Project getProjectByName(String projectName)
  {
    for (Project p : projects)
    {
      if (p.getName().equals(projectName))
      {
        return p;
      }
    }
    return null;
  }

  /**
   * Edits a Project object in the list with the given name
   * @param newName the new name of the Project object
   * @param oldName the name of the Project object to be edited
   * @param status the new status of the Project object
   */
  public void editProject(String newName, String oldName, String status)
  {
    Project temp = getProjectByName(oldName);

    if (newName.equals(oldName))
    {
      temp.setStatus(status);
    }
    else if (getProjectByName(newName) == null)
    {
      temp.setStatus(status);
      temp.setProjectName(newName);
    }
    else
    {
      throw new IllegalArgumentException("Project already exists");
    }
  }

  /**
   * Gets a number of Project objects in the list
   * @return the number of Project objects inside a list
   */
  public int size()
  {
    return projects.size();
  }

  /**
   * Removes a Project object from the list.
   * @param project the Project object to be removed
   */
  public void remove(Project project)
  {
    projects.remove(project);
  }

  /**
   * Gets a Project object with the given index.
   * @param index the index of the Project object in the list
   * @return the Project object with the given index from the list
   */
  public Project get(int index)
  {
    return projects.get(index);
  }

  /**
   * Removes team roles and remove Task objects from Employees when exporting to XML
   */
  public void exportingXML(){
    for (Project project : projects){
      project.deleteTeamRoles();
    }
  }

  /**
   * Gets a String representation of the ProjectList
   * @return a String containing information about all Task objects in the list - each Project object followed by a new line character
   */
  public String toString()
  {
    String temp = "";
    for (Project p : projects)
    {
      temp += p + "\n";
    }
    return temp;
  }
}
