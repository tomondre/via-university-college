/*package Test;

import model.*;

public class ProjectManagmentSystemTest
{
  public static void main(String[] args)
  {
   ProjectManagmentSystem system = new ProjectManagmentSystem();
   Employee responsibleEmployee = new Employee(25, "Peter", "Petersen");
    System.out.println(system);
    system.addProject("NewProject");
    System.out.println(system);
    system.addRequirement("NewProject", new Requirement(25,4, "ofnodnsfsnf", 50,new MyDate(25,11,2020), responsibleEmployee));
    System.out.println(system);
    system.addRequirement("NewProject", new Requirement(24,3, "ofnodnsfsnf", 50,new MyDate(25,11,2020), responsibleEmployee));
    System.out.println(system);
    system.addProject("newneww");
    system.addRequirement("newneww", new Requirement(24,2, "ofnodnsfsnf", 50,new MyDate(25,11,2020),responsibleEmployee));
    system.addEmployee(responsibleEmployee);
    system.addTask("NewProject", 25,
        new Task(20, "kddskdmdks", 25, new MyDate(25, 11, 2020),
            responsibleEmployee));
    system.addTask("NewProject", 25,
        new Task(19, "kddskdmdks",  25, new MyDate(25, 11, 2020),
            responsibleEmployee));
    system.addTask("newneww", 30,
        new Task(28, "kddskdmdks",  25, new MyDate(25, 11, 2020),
            responsibleEmployee));
    system.addTask("NewProject", 25,
        new Task(1, "kddskdmdks", 25, new MyDate(25, 11, 2020),
            responsibleEmployee));
    system.addTask("NewProject", 25,
        new Task(2, "kddskdmdks",  25, new MyDate(25, 11, 2020),
            responsibleEmployee));
    system.addTask("NewProject", 25,
        new Task(3, "kddskdmdks",  25, new MyDate(25, 11, 2020),
            responsibleEmployee));
    system.addTask("NewProject", 25,
        new Task(4, "kddskdmdks",  25, new MyDate(25, 11, 2020),
            responsibleEmployee));
    system.addRequirement("NewProject", new Requirement(1,1, "ofnodnsfsnf", 50,new MyDate(25,11,2020),responsibleEmployee));
    system
        .addRequirement("NewProject", new Requirement(4,8, "'f,s,p[dslvs'", 50,new MyDate(25,11,2020),responsibleEmployee));
    system.addRequirement("NewProject",
        new Requirement(2,5, "f]dl]pfdss/f/s/f][sf", 50,new MyDate(25,11,2020),responsibleEmployee));
    system.addRequirement("NewProject",
        new Requirement(3,5, "fpmmdspf;d.sflskf", 50,new MyDate(25,11,2020),responsibleEmployee));
    system.addRequirement("NewProject", new Requirement(8,7, "a,da.'csacc.", 50,new MyDate(25,11,2020),responsibleEmployee));
    System.out.println(system);
    system.getProjectByName("NewProject").sortRequirements();
    system.addUsedHourToTask("NewProject", 25, 3, 5);
    system.addUsedHourToTask("NewProject", 15, 3, 5);
    system.addUsedHourToTask("NewProject", 25, 3, 5);
    System.out.println(system);
    System.out.println(system);
    system.addTask("NewProject", 24,
        new Task(4, "kddskdmdks",  25, new MyDate(25, 11, 2020),
            responsibleEmployee));
    system.setTaskDone("NewProject", 24, 4);
    System.out.println(system);
    system.setTaskDone("NewProject", 25, 24);
    system.setTaskDone("NewProject", 25, 25);
//    system.setTaskDone("NewProject", 25, 20);
    system.setTaskDone("NewProject", 25, 19);
    system.setTaskDone("NewProject", 25, 1);
    system.setTaskDone("NewProject", 25, 2);
    system.setTaskDone("NewProject", 25, 3);
    system.setTaskDone("NewProject", 25, 4);
    System.out.println(system);
    System.out.println(
        "*************************************************************************************************************");
    system.addEmployee(new Employee(25,"Toams", "Ondrejka"));
    system.addEmployee(new Employee(15,"ms", "Ondre"));
    system.addEmployee(new Employee(5,"ToaSssdsds", "Ondsdadasdarejka"));
    system.addEmployeeToAProject("NewProject", 25, "Scrum");
    system.addEmployeeToAProject("NewProject", 5, "Scrum");
    system.addTeamMemberToTask("NewProject", 25,20,5);
    system.addTeamMemberToTask("NewProject", 25,1,5);
    system.addTeamMemberToTask("NewProject", 25,1,5);
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println(system.getEmployeeAssignedToProject("NewProject", 5).getRole());
    System.out.println("***************************************************************************************");
    System.out.println(system.getEmployeeAssignedToProject("NewProject", 5));
    Requirement t = system.getRequirementByID("NewProject", 25).copy();
    System.out.println(t);

    System.out.println(system.getRequirementByID("NewProject", 25));

    system.moveToArchive("NewProject");
    System.out.println("BlaBla");
    System.out.println(system.getArchivedProjects().getProjectByName("NewProject").getProjectTeam());
    system.getArchivedProjects().getProjectByName("NewProject").getTeamMember(5);



    //     tem = system.getArchivedProjects();
//    System.out.println(tem[0].getTeamMember(5));
//    System.out.println("------------------------------------------------------------");
//    Task[] tempTask = tem[0].getTeamMember(5).getWorkingOnTasks();
//    for (Task task:tempTask)
//    {
//      System.out.println("task");
//    }
//    System.out.println("//////////////////////////////////////////////////////////////");
//    //Employee mp = tem[0].getEmployeeAssignedToProject("NewProject", 5);
//    System.out.println(tem[0]);
//    System.out.println(tem[0].getTeamMember(5));
//    System.out.println(system.getProjectByName("NewProject"));

  }
}
*/