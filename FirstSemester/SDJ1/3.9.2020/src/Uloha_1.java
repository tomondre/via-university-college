import java.util.Scanner;
public class Uloha_1
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Prvé číslo ");
    double prve = keyboard.nextDouble();
    System.out.print("Druhé číslo");
    double druhe = keyboard.nextDouble();
    System.out.print("Tretie číslo ");
    double tretie = keyboard.nextDouble();
    double vysledok = prve + druhe + tretie;
    System.out.print(vysledok);
  }
}
