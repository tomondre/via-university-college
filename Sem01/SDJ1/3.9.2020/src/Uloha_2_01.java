import java.util.Scanner;
public class Uloha_2_01
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Oblubne mesto: ");
    String mesto = keyboard.nextLine();

    int dlzka = mesto.length();
    System.out.println("Pocet písmen: " + dlzka);

    mesto = mesto.toUpperCase();
    System.out.println(mesto);

    mesto = mesto.toLowerCase();
    System.out.println(mesto);

    System.out.println("Ktory znak? ");
    int miesto = keyboard.nextInt();
    miesto--;

    char znak = mesto.charAt(miesto);
    System.out.println(znak);
  }
}
