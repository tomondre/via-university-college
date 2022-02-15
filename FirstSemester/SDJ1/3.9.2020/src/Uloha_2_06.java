import java.util.Scanner;
public class Uloha_2_06
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Name: ");
    String a = keyboard.nextLine();

    System.out.println("Age: ");
    String b = keyboard.nextLine();

    System.out.println("City: ");
    String c = keyboard.nextLine();

    System.out.println("College: ");
    String d = keyboard.nextLine();

    System.out.println("Proffesion: ");
    String e = keyboard.nextLine();

    System.out.println("Animal: ");
    String f = keyboard.nextLine();

    System.out.println("Name of animal: ");
    String g = keyboard.nextLine();

    System.out.println("There once was a person nammed " + a + " who lived in " + c + ". At the age of " + b + ", " + a + " went to college at " + d + ". " + a + " graduated and went to work as a " + e + ". Then, "+a+" adotped a " + f + " named "+g+". They both lived happily ever after!");

  }
}
