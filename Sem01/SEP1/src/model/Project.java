package model;

import java.io.Serializable;

/**
 * A class of Project object
 */
public class Project implements Serializable
{
  private String projectName;
  private EmployeeList projectTeam;
  private RequirementList requirementList;
  private String status;
  public static final String DONE = "Done";
  public static final String ARCHIVED = "Archived";
  public static final String IN_PROCESS = "In process";

  /**
   * A constructor for creating Project.
   *
   * @param projectName the name of the Project object
   * @param status      the status of the Project object
   */
  public Project(String projectName, String status)
  {
    projectTeam = new EmployeeList();
    this.projectName = projectName;
    requirementList = new RequirementList();
    setStatus(status);
  }

  /**
   * A constructor called when copying a Project object.
   *
   * @param projectName     the unique project name of the Project object
   * @param status          the status of the Project object
   * @param requirementList the requirement list of the Project object
   * @param projectTeam the assigned employee objects list of the Project object
   */
  public Project(String projectName, String status,
      RequirementList requirementList, EmployeeList projectTeam)
  {
    this.projectName = projectName;
    setStatus(status);
    this.requirementList = requirementList;
    this.projectTeam = projectTeam;
  }

  /**
   * Edits fields inside a Project object.
   * @param name the project name of the Project object.
   */
  public void setProjectName(String name)
  {
    projectName = name;
  }

  /**
   * Sets the status field of the Project object.
   * @param status the status of the Project object to be set
   */
  public void setStatus(String status)
  {
    this.status = status;
  }

  /**
   * Gets the String representation of the Project object.
   *
   * @return the name of the Project object
   */
  public String getName()
  {
    return projectName;
  }

  /**
   *  Gets a status of the Project object.
   * @return the status of the Project object
   */
  public String getStatus()
  {
    return status;
  }

  /**
   * Adds an existing Employee object to the project EmployeeList.
   * @param employee the Employee object to be added to the projectTeam
   * @param role the role of the Employee object that is being added
   */
  public void addTeamMember(Employee employee, String role)
  {
    employee.setRole(role);
    projectTeam.addEmployee(employee);
  }

  /**
   * Edits the role of existing Employee object inside the project EmployeeList
   * @param employee the Employee in project EmployeeList to edit its role
   * @param role the String an Employee is changing its role to
   */
  public void editRoleTeamMember(Employee employee, String role)
  {
    Employee temp = projectTeam.getEmployeeByID(employee.getId());
    temp.setRole(role);
  }

  /**
   * Gets the EmployeeList of Employees assigned to Project
   * @return the project EmployeeList
   */
  public EmployeeList getAllTeamMembers()
  {
    return projectTeam;
  }

  /**
   * Remove the role of every Employee assigned to Project when moving to ArchiveProjects
   */
  public void deleteTeamRoles()
  {
    projectTeam.deleteRoles();
  }

  /**
   * Adds a Requirement to the RequirementList
   * @param requirement
   */
  public void addRequirement(Requirement requirement)
  {
    requirementList.addRequirement(requirement);
  }

  /**
   * Gets a Requirement object with the given ID
   * @param requirementID the ID of the Requirement object to be returned
   * @return the Requirement Object with the given ID
   */
  public Requirement getRequirementByID(String requirementID)
  {
    return requirementList.getRequirementByID(requirementID);
  }

  /**
   * Gets a RequirementList with the Requirement objects assigned to the Project.
   * @return the RequirementList field of the project
   */
  public RequirementList getAllRequirements()
  {
    return requirementList;
  }

  /**
   * Gets a copy of an existing Project.
   * @return new Project with copied Project fields
   */
  public Project copy()
  {
    return new Project(projectName, status, requirementList.copy(),
        projectTeam.copy());
  }

  /**
   * Gets a String representation of the Project.
   * @return the String containing information about the Project
   */
  public String toString()
  {
    return projectName + " (" + status + ")";
  }
}
