import java.util.Scanner;
public class Uloha_2_05_01

{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    boolean y = true;
    double sum = 0;
    int cyklus = 0;
    double vstup = 2;
    System.out.println("Napis prvu hodnotu");
    while (y==true) {
      vstup = keyboard.nextDouble();
      if(vstup == 0){
        y = false;
      }
      else{
        sum = vstup + sum;
        System.out.print("Priebezny sucet: ");
        System.out.println(sum);
        System.out.print("Cislo cislo: ");
        System.out.println(cyklus+1);
        System.out.println("---------Pre priemer cisel napis 0----------");
        cyklus++;
      }

    }
    sum = sum / cyklus;
    System.out.println("Priemer: ");
    System.out.println(sum);
  }
}