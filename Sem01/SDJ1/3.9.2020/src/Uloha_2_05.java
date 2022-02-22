import java.util.Scanner;
public class Uloha_2_05
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Prvy vysledok ");
    double prvy = keyboard.nextInt();

    System.out.println("Druhy vysledok ");
    double druhy = keyboard.nextInt();

    System.out.println("Treti vysledok ");
    double treti = keyboard.nextInt();

    double vysledok = (prvy + druhy + treti)/3;
    System.out.println(vysledok);

    }
}
