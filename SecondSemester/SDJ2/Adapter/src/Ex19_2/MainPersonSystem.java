package Ex19_2;

import java.util.Scanner;

public class MainPersonSystem
{
  public static void main(String[] args)
  {
    PersonStorage storage = new DBPersonStorage();

    Scanner keyboard = new Scanner(System.in);

    while (true)
    {
      System.out.println("Add/Get/Exit>");

      String ans = keyboard.nextLine();

      if (ans.equalsIgnoreCase("add"))
      {
        System.out.println("Name> ");
        String name = keyboard.nextLine();

        System.out.println("dob> ");
        String dob = keyboard.nextLine();

        System.out.println("ssn> ");
        int ssn = keyboard.nextInt();

        storage.addPerson(new Person(name, dob, ssn));

        System.out.println("Person successfully added!");
      }
      else if (ans.equalsIgnoreCase("get"))
      {
        System.out.println("SSN>");
        int ssn = keyboard.nextInt();

        Person person = storage.getPerson(ssn);
        System.out.println(person);
      }
      else if (ans.equalsIgnoreCase("exit"))
      {
        break;
      }
    }
  }
}
