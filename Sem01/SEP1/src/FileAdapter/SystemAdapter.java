package FileAdapter;

import com.google.gson.Gson;
import model.*;
import org.json.JSONObject;
import org.json.XML;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Class controlling the system, saving the system to binary file and exporting XML file
 */
public class SystemAdapter {
    private MyFileIO mfio;
    private String fileName;
    private MyTextFileIO mtxtfio;

    /**
     * Constructor for creating SystemAdapter object and initializing binary file reader
     *
     * @param fileName the file name of .bin document with bin filetype
     */
    public SystemAdapter(String fileName) {
        mfio = new MyFileIO();
        this.fileName = fileName;
        this.mtxtfio = new MyTextFileIO();
    }

    /**
     * Adds project to the system after reading the binary file
     *
     * @param name   the name of the Project object to be added
     * @param status the status of the Project object to be added
     * @throws IllegalArgumentException
     */
    public void addProject(String name, String status)
            throws IllegalArgumentException {
        ProjectManagementSystem system = getSystem();
        Project toAdd = new Project(name, status);
        system.getAllProjectsOngoing().addProject(toAdd);
        save(system);
    }

    /**
     * Edits the project with the given name
     *
     * @param newName the name of the Project object after edit
     * @param oldName the name of the Project object to be edited
     * @param status  the status of the Project object after edit
     * @throws IllegalArgumentException
     */
    public void editProject(String newName, String oldName, String status)
            throws IllegalArgumentException {
        ProjectManagementSystem system = getSystem();
        try {
            system.getAllProjectsOngoing().editProject(newName, oldName, status);
        } finally {
            save(system);
        }
    }

    /**
     * Moves project from onGoing projects to archived projects.
     *
     * @param projectName the name of the Project object to be moved to archive
     */
    public void moveProjectToArchive(String projectName) {
        ProjectManagementSystem system = getSystem();
        system.moveToArchive(projectName);
        save(system);
    }

    /**
     * Adds new Requirement object to the RequirementList of the given Project
     *
     * @param projectName         the name of the Project object to add the Requirement into
     * @param requirementId       the ID of the Requirement object to be added
     * @param priorityNumber      the priority number of the Requirement object to be added
     * @param description         the description of the Requirement object to be added
     * @param estimateTime        the estimate time of the Requirement object to be added
     * @param status              the status of the Requirement object to be added
     * @param requirementType     the type of the Requirement object to be added
     * @param deadline            the deadline og the Requirement object to be added
     * @param responsibleEmployee the responsible Employee of the Requirement object
     */
    public void addRequirement(String projectName, String requirementId,
                               int priorityNumber, String description, double estimateTime,
                               String status, String requirementType, MyDate deadline,
                               Employee responsibleEmployee) {
        ProjectManagementSystem system = getSystem();
        system.getAllProjectsOngoing().getProjectByName(projectName).addRequirement(
                new Requirement(requirementId, priorityNumber, description,
                        estimateTime, status, requirementType, deadline,
                        responsibleEmployee));
        save(system);
    }

    /**
     * Edits a Requirement in the given path
     *
     * @param projectName         the name of the project where the Requirement is stored
     * @param requirementId       the id of the Requirement to edited
     * @param priorityNumber      the priority number of Requirement object to be edited
     * @param description         the description of Requirement object to be edited
     * @param estimateTime        the time estimation of Requirement object to be edited
     * @param status              the status of Requirement object to be edited
     * @param requirementType     the type of Requirement object to be edited
     * @param deadline            the deadline of Requirement object to be edited
     * @param responsibleEmployee the responsible Employee of Requirement object to be edited
     */
    public void setRequirement(String projectName, String requirementId,
                               int priorityNumber, String description, double estimateTime,
                               String status, String requirementType, MyDate deadline,
                               Employee responsibleEmployee) {
        ProjectManagementSystem system = getSystem();
        system.getRequirementByID(projectName, requirementId)
                .set(priorityNumber, description, estimateTime, deadline, status,
                        requirementType, responsibleEmployee);
        save(system);
    }

    /**
     * Removes a Requirement object with the given name from the system
     *
     * @param projectName   the name of the Project object to be removed
     * @param requirementID the id of requirement object to be removed
     */
    public void removeRequirement(String projectName, String requirementID) {
        ProjectManagementSystem system = getSystem();
        system.getAllProjectsOngoing().getProjectByName(projectName)
                .getAllRequirements().removeRequirement(requirementID);
        save(system);
    }

    /**
     * Checks statuses of Requirement objects in Project with the given name
     *
     * @param projectName the name of Project with Requirement objects to be checked
     */
    public void checkRequirementsStatus(String projectName) {
        ProjectManagementSystem system = getSystem();
        system.getAllRequirements(projectName).checkStatus();
        save(system);
    }

    /**
     * Adds Task object to the Requirement object with the given path.
     *
     * @param projectName   the name of the Project object where Task is to be added
     * @param requirementID the ID of the Requirement object where Task is to be added
     * @param task          the Task object to be added
     */
    public void addTask(String projectName, String requirementID, Task task) {
        ProjectManagementSystem system = getSystem();
        system.getRequirementByID(projectName, requirementID).addTask(task);
        save(system);
    }

    /**
     * Edits a Task object with a given path from the system
     *
     * @param projectName         the name of Project with a Task to be edited
     * @param requirementID       the ID of a Requirement object with a Task to be edited
     * @param taskID              the ID of a Task object to be edited
     * @param description         the description of a Task object to edit
     * @param status              the status of a Task to edit
     * @param timeUsed            the time used of Task object to edit
     * @param estimatedTime       the time estimation of Task object to edit
     * @param deadline            the deadline of Task object to edit
     * @param employees           the Employee objects assigned to Task to edit
     * @param responsibleEmployee the responsible Employee object of Task to edit
     */
    public void setTask(String projectName, String requirementID, int taskID,
                        String description, boolean status, double timeUsed, double estimatedTime,
                        MyDate deadline, EmployeeList employees, Employee responsibleEmployee) {
        ProjectManagementSystem system = getSystem();
        system.getAllTasks(projectName, requirementID).getTaskById(taskID)
                .set(description, status, timeUsed, estimatedTime, deadline, employees,
                        responsibleEmployee);
        save(system);
    }

    /**
     * Removes a Task object with the given path from the system
     *
     * @param projectName   the name of the Project object with a Task to be removed
     * @param requirementID the ID of Requirement object with a Task to be removed
     * @param taskID        the ID of the Task object to be removed
     */
    public void removeTask(String projectName, String requirementID, int taskID) {
        ProjectManagementSystem system = getSystem();
        system.getRequirementByID(projectName, requirementID).removeTask(taskID);
        save(system);
    }

    /**
     * Reads the ProjectManagementSystem from the binary file path given in constructor
     *
     * @return the ProjectManagementSystem from the binary file
     */
    public ProjectManagementSystem getSystem() {
        ProjectManagementSystem system = new ProjectManagementSystem();
        try {
            system = (ProjectManagementSystem) mfio.readObjectFromFile(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Error reading file");
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found");
        }
        return system;
    }

    /**
     * Adds an Employee into the system's EmployeeList
     *
     * @param employee the Employee object to be added into the system's EmployeeList
     */
    public void addEmployee(Employee employee) {
        ProjectManagementSystem system = getSystem();
        try {
            system.getAllEmployees().addEmployee(employee);
        } finally {
            save(system);
        }
    }

    /**
     * Edits an Employee object in the system's EmployeeList
     *
     * @param employee    the Employee object to be deleted
     * @param oldEmployee the Employee object with edited fields
     * @throws IllegalArgumentException
     */
    public void editEmployee(Employee employee, Employee oldEmployee)
            throws IllegalArgumentException {
        ProjectManagementSystem system = getSystem();
        try {
            system.getAllEmployees().editEmployee(employee, oldEmployee);
        } finally {
            save(system);
        }
    }

    /**
     * Adds an Employee object into the Project with the given name
     *
     * @param projectName the name of the project where the Task object is to be added
     * @param employee    the Employee object to be added
     * @param role        the Employee role in the Project to be added
     */
    public void addEmployeeToProject(String projectName, Employee employee,
                                     String role) {
        ProjectManagementSystem system = getSystem();
        system.getAllProjectsOngoing().getProjectByName(projectName)
                .addTeamMember(employee, role);
        system.getAllEmployees().getEmployeeByID(employee.getId()).setRole(role);
        save(system);
    }

    /**
     * Adds a Task object to the given Employee object
     *
     * @param employee the Employee object to add Task to
     * @param task     the Task object to be added to Employee
     */
    public void addTaskToEmployee(Employee employee, Task task) {
        ProjectManagementSystem system = getSystem();
        system.getAllEmployees().getEmployeeByID(employee.getId()).addTask(task);
        save(system);
    }

    /**
     * Removes the Task object from the given Employee object
     *
     * @param employee the Employee object to remove Task from
     * @param task     the Task object to be removed from Employee
     */
    public void removeTaskFromEmployee(Employee employee, Task task) {
        ProjectManagementSystem system = getSystem();
        system.getAllEmployees().getEmployeeByID(employee.getId()).removeTask(task);
        save(system);
    }

    /**
     * Edits a role of the given Employee object in the Project with the given name
     *
     * @param projectName the name of the Project object with Employee to edit
     * @param employee    the Employee object to be edited
     * @param role        the new Employee role in Project
     */
    public void changeRoleEmployee(String projectName, Employee employee, String role) {
        ProjectManagementSystem system = getSystem();
        system.getAllProjectsOngoing().getProjectByName(projectName).editRoleTeamMember(employee, role);
        save(system);
    }

    /**
     * Saves the given ProjectManagementSystem into binary file
     *
     * @param system the ProjectManagementSystem to be saved
     */
    public void save(ProjectManagementSystem system) {
        try {
            mfio.writeToFile(fileName, system);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Error writing to file");
        }
    }

    /**
     * Exports ongoing ProjectList object into external XML file
     */
    public void exportXML() {
        Gson json = new Gson();
        ProjectList tempProjects = getSystem().getAllProjectsOngoing();
        tempProjects.exportingXML();
        String temp = XML.toString(
                new JSONObject(json.toJson(tempProjects)));
        temp = "<ongoingProjects>" + temp;
        temp += "</ongoingProjects>";
        try {
            mtxtfio.writeToFile("../ColourITWebPage/XML/export.xml", temp);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
