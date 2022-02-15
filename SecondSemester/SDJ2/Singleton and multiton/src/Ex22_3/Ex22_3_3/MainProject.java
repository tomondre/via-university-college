package Ex22_3.Ex22_3_3;

public class MainProject
{
  public static void main(String[] args)
  {
    Project project1 = new Project("Project 1", MultitonKey.dk);
    project1.addGlossaryItem("Client",
        "The client part of " + "client/server application.");
    project1
        .addGlossaryItem("User", "End user in form of a doctor or a nurse.");
    project1.addGlossaryItem("Account",
        "A location on the server application storing username, "
            + "password and phone number.");

    Project project2 = new Project("Project 2", MultitonKey.uk);
    project2.addGlossaryItem("Client",
        "The client part of " + "client/server application.");
    project2
        .addGlossaryItem("User", "End user in form of a doctor or a nurse.");


    System.out.println("DK glossary :" + ProjectGlossary.getInstance(MultitonKey.dk) + " \n");

    System.out.println("UK glossary : " + ProjectGlossary.getInstance(MultitonKey.uk));
  }
}
