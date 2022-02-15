import java.util.Scanner;

public class Sum_Of_Arrays
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Prva skupina 4 cisel");

    int[] prve = {keyboard.nextInt(), keyboard.nextInt(), keyboard.nextInt(),
        keyboard.nextInt()};
    System.out.println("Druha skupina 4 cisel");
    int[] druhe = {keyboard.nextInt(), keyboard.nextInt(), keyboard.nextInt(),
        keyboard.nextInt()};
    int[] sucet = new int[4];
    for (int i = 0; i < prve.length; i++)
    {
      sucet[i] = prve[i] + druhe[i];
    }
    for (int i = 0; i < sucet.length; i++)
    {
      System.out.println(sucet[i]);
    }
  }
}
