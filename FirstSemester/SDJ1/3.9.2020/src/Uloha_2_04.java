import java.util.Scanner;
public class Uloha_2_04
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Meno: ");
    String meno = keyboard.nextLine();

    System.out.print("Vek: ");
    double vek = keyboard.nextDouble();

    keyboard.nextLine();

    System.out.print("Adresa: ");
    String adresa = keyboard.nextLine();

    System.out.print(meno + vek + adresa);

  }
}
