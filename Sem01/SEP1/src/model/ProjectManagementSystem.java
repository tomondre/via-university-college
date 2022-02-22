package model;

import java.io.Serializable;

/**
 * A class containing
 */
public class ProjectManagementSystem implements Serializable
{
  private EmployeeList employees;
  private ProjectList ongoingProjectList;
  private ProjectList archivedProjects;

  /**
   * No-argument constructor initializing all ProjectManagementSystem's fields.
   */
  public ProjectManagementSystem()
  {
    employees = new EmployeeList();
    ongoingProjectList = new ProjectList();
    archivedProjects = new ProjectList();
  }

  //********************************projectList************************************

  /**
   * Gets a ProjectList of ongoing Project objects
   *
   * @return the ongoing ProjectList object
   */
  public ProjectList getAllProjectsOngoing()
  {
    return ongoingProjectList;
  }

  /**
   * Gets a ProjectList of archived files object
   *
   * @return the archived ProjectList object
   */
  public ProjectList getAllArchivedProjects()
  {
    return archivedProjects;
  }

  //******************************Requirement***********************************

  /**
   * Gets RequirementList of the Project object with the given name
   *
   * @param projectName the name of the project
   * @return the RequirmentList of the given Project object
   */
  public RequirementList getAllRequirements(String projectName)
  {
    if (getAllProjectsOngoing().getProjectByName(projectName) != null)
    {
      return getAllProjectsOngoing().getProjectByName(projectName)
          .getAllRequirements();
    }
    else
    {
      return getAllArchivedProjects().getProjectByName(projectName)
          .getAllRequirements();
    }
  }

  /**
   * Gets a Requirement object with the given Project and Requirement ID path
   *
   * @param projectName   the name of the Project object where the Requirement is located
   * @param requirementID the ID of the Requirement object
   * @return the Requirement with the given project name and requirement id path
   */
  public Requirement getRequirementByID(String projectName,
      String requirementID)
  {
    if (getAllProjectsOngoing().getProjectByName(projectName) != null)
    {
      return getAllProjectsOngoing().getProjectByName(projectName)
          .getRequirementByID(requirementID);
    }
    else
    {
      return getAllArchivedProjects().getProjectByName(projectName)
          .getRequirementByID(requirementID);
    }
  }

  //**********************************Tasks*************************************

  /**
   * Gets TaskList object of the Requirement with the given project name and requirement id path
   *
   * @param projectName   the name of the Project where the TaskList object is located
   * @param requirementId the ID of the Requirement where the TaskList object is locate
   * @return the TaskList with the given Project name and Requirement id path
   */
  public TaskList getAllTasks(String projectName, String requirementId)
  {
    return getAllRequirements(projectName).getRequirementByID(requirementId)
        .getTaskList();
  }

  //**********************************Employee**********************************

  /**
   * Gets EmployeeList containing all Employee objects made in the System
   *
   * @return the EmployeeList with Employee objects
   */
  public EmployeeList getAllEmployees()
  {
    return employees;
  }

  //*****************************Archive****************************************

  /**
   * Moves a Project object with the given name to archivedProject ProjectList
   *
   * @param projectName the name of the Project to be moved to archived
   */
  public void moveToArchive(String projectName)
  {
    if (getAllProjectsOngoing().getProjectByName(projectName) != null)
    {
      Project temp = getAllProjectsOngoing().getProjectByName(projectName);
      EmployeeList empl = temp.getAllTeamMembers();
      archivedProjects.addProject(temp.copy());
      getAllEmployees().employeesDeleteRoles(empl);
      ongoingProjectList.remove(temp);
    }
  }

  /**
   * Gets a String representation of the ProjectManagementSystem object
   *
   * @return the String containing information about ProjectManagementSystem
   */
  public String toString()
  {
    return ongoingProjectList.toString();
  }
}