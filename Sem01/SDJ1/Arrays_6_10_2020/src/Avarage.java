import java.util.Scanner;
public class Avarage
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    double sucet = 0;
    System.out.println("Napis cisla");
    int[] cisla = {keyboard.nextInt(), keyboard.nextInt(), keyboard.nextInt(),
        keyboard.nextInt(), keyboard.nextInt()};
    for (int i = 0; i < cisla.length; i++)
    {
      sucet =(double) (sucet + cisla[i]);
    }
    System.out.println("Sucet je: " + sucet);
    System.out.print("Priemer cisel je: ");
    System.out.println(sucet/ cisla.length);
  }
}
